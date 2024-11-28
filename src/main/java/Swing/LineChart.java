package Swing;

import Utils.Conexao;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineChart extends JFrame {
    public LineChart() {
        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);  // Create chart here

        // Criando o ChartPanel com zoom e arraste habilitado
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.WHITE);

        // Habilitando o zoom com a roda do mouse
        chartPanel.setMouseWheelEnabled(true); // Habilita zoom com a roda do mouse
        chartPanel.setMouseZoomable(true, false); // Permite zoom apenas no eixo X
        // O ChartPanel já permite panning (arraste) por padrão, então não é necessário chamar setMouseDragged.

        add(chartPanel);

        pack();
        setTitle("IDH por População");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();

        // Usando a classe Conexao para conectar ao banco de dados
        Conexao conexao = new Conexao();
        try (Connection conn = conexao.conectar(); Statement stmt = conn.createStatement()) {

            // Consulta SQL para Goiânia
            String queryGoiania = "SELECT populacao, idh_geral, cidade FROM cidade WHERE microregiao = 'Goiânia'";
            ResultSet rsGoiania = stmt.executeQuery(queryGoiania);

            XYSeries goianiaSeries = new XYSeries("Goiânia");
            while (rsGoiania.next()) {
                double populacao = rsGoiania.getDouble("populacao");
                double idh = rsGoiania.getDouble("idh_geral");
                String cidade = rsGoiania.getString("cidade");
                goianiaSeries.add(idh, populacao);  // Trocar a ordem: IDH no eixo X e População no eixo Y
            }
            dataset.addSeries(goianiaSeries);

            // Consulta SQL para Anápolis
            String queryAnapolis = "SELECT populacao, idh_geral, cidade FROM cidade WHERE microregiao = 'Anápolis'";
            ResultSet rsAnapolis = stmt.executeQuery(queryAnapolis);

            XYSeries anapolisSeries = new XYSeries("Anápolis");
            while (rsAnapolis.next()) {
                double populacao = rsAnapolis.getDouble("populacao");
                double idh = rsAnapolis.getDouble("idh_geral");
                String cidade = rsAnapolis.getString("cidade");
                anapolisSeries.add(idh, populacao);  // Trocar a ordem: IDH no eixo X e População no eixo Y
            }
            dataset.addSeries(anapolisSeries);
            conexao.desconectar();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {
        // Criar o gráfico
        JFreeChart chart = ChartFactory.createXYLineChart(
                "IDH por População",
                "IDH", // IDH será o eixo X
                "População", // População será o eixo Y
                dataset
        );

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        // Configuração das séries (sem linhas, apenas os pontos)
        renderer.setSeriesLinesVisible(0, false); // Série Goiânia: desabilitar linhas
        renderer.setSeriesShapesVisible(0, true); // Série Goiânia: habilitar pontos
        renderer.setSeriesPaint(0, Color.RED);    // Cor da série Goiânia
        renderer.setSeriesStroke(0, new BasicStroke(2.0f)); // Espessura da linha para Goiânia (invisível)

        renderer.setSeriesLinesVisible(1, false); // Série Anápolis: desabilitar linhas
        renderer.setSeriesShapesVisible(1, true); // Série Anápolis: habilitar pontos
        renderer.setSeriesPaint(1, Color.BLUE);   // Cor da série Anápolis
        renderer.setSeriesStroke(1, new BasicStroke(2.0f)); // Espessura da linha para Anápolis (invisível)

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.WHITE);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        // Adicionar as anotações (nomes das cidades) após o gráfico ser criado
        addAnnotationsToPlot(plot);
        
        return chart;
    }

    private void addAnnotationsToPlot(XYPlot plot) {
        // Adicionar as anotações (nomes das cidades) após o gráfico ser criado
        Conexao conexao = new Conexao();
        try (Connection conn = conexao.conectar(); Statement stmt = conn.createStatement()) {

            // Consulta SQL para Goiânia
            String queryGoiania = "SELECT populacao, idh_geral, cidade FROM cidade WHERE microregiao = 'Goiânia'";
            ResultSet rsGoiania = stmt.executeQuery(queryGoiania);
            while (rsGoiania.next()) {
                double populacao = rsGoiania.getDouble("populacao");
                double idh = rsGoiania.getDouble("idh_geral");
                String cidade = rsGoiania.getString("cidade");

                // Adicionar anotação para Goiânia
                XYTextAnnotation annotation = new XYTextAnnotation(cidade, idh, populacao);
                annotation.setFont(new Font("Arial", Font.PLAIN, 12));
                annotation.setPaint(Color.BLACK); // Cor do texto
                plot.addAnnotation(annotation);
            }

            // Consulta SQL para Anápolis
            String queryAnapolis = "SELECT populacao, idh_geral, cidade FROM cidade WHERE microregiao = 'Anápolis'";
            ResultSet rsAnapolis = stmt.executeQuery(queryAnapolis);
            while (rsAnapolis.next()) {
                double populacao = rsAnapolis.getDouble("populacao");
                double idh = rsAnapolis.getDouble("idh_geral");
                String cidade = rsAnapolis.getString("cidade");

                // Adicionar anotação para Anápolis
                XYTextAnnotation annotation = new XYTextAnnotation(cidade, idh, populacao);
                annotation.setFont(new Font("Arial", Font.PLAIN, 12));
                annotation.setPaint(Color.BLACK); // Cor do texto
                plot.addAnnotation(annotation);
            }
            conexao.desconectar();

        } catch (Exception e) {
            e.printStackTrace();
        }
        conexao.desconectar();
    }
    
    
    /*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LineChart example = new LineChart();
            example.setVisible(true);
        });
    }
    */
}
