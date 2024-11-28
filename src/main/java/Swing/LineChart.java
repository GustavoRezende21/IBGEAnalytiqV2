package Swing;

import Utils.Conexao;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineChart extends JFrame {

    public LineChart() {
        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        // Criando o ChartPanel com zoom e arraste habilitado
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.WHITE);

        // Habilitando o zoom com a roda do mouse
        chartPanel.setMouseWheelEnabled(true); // Habilita zoom com a roda do mouse
        chartPanel.setMouseZoomable(true, true); // Permite zoom apenas no eixo X
        add(chartPanel);

        pack();
        setTitle("IDH por População");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        Conexao conexao = new Conexao();

        String query = "SELECT populacao, idh_geral, cidade, microregiao FROM cidade "
                + "WHERE microregiao IN ('Goiânia', 'Anápolis')";

        try (Connection conn = conexao.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            XYSeries goianiaSeries = new XYSeries("Goiânia");
            XYSeries anapolisSeries = new XYSeries("Anápolis");

            while (rs.next()) {
                double populacao = rs.getDouble("populacao");
                double idh = rs.getDouble("idh_geral");
                String cidade = rs.getString("cidade");
                String microregiao = rs.getString("microregiao");

                if (microregiao.equals("Goiânia")) {
                    goianiaSeries.add(idh, populacao);
                    cityMap.put(idh + "," + populacao, cidade); // Salvar cidade para o ponto
                } else if (microregiao.equals("Anápolis")) {
                    anapolisSeries.add(idh, populacao);
                    cityMap.put(idh + "," + populacao, cidade); // Salvar cidade para o ponto
                }
            }

            dataset.addSeries(goianiaSeries);
            dataset.addSeries(anapolisSeries);

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
        addAnnotationsToPlot(plot, dataset);

        return chart;
    }

    private void addAnnotationsToPlot(XYPlot plot, XYDataset dataset) {
        for (int i = 0; i < dataset.getSeriesCount(); i++) {
            XYSeries series = ((XYSeriesCollection) dataset).getSeries(i);

            for (int j = 0; j < series.getItemCount(); j++) {
                double idh = series.getX(j).doubleValue();
                double populacao = series.getY(j).doubleValue();
                String key = idh + "," + populacao; // Usar a mesma chave que foi salva no cityMap

                // Obter o nome da cidade correspondente
                String cidade = cityMap.get(key);

                if (cidade != null) { // Garantir que a cidade foi encontrada
                    XYTextAnnotation annotation = new XYTextAnnotation(cidade, idh, populacao);
                    annotation.setFont(new Font("Arial", Font.PLAIN, 12));
                    annotation.setPaint(Color.BLACK);
                    plot.addAnnotation(annotation);
                }
            }
        }
    }

    private Map<String, String> cityMap = new HashMap<>();

}
