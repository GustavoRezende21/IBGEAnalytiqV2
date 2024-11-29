/*
 * Copyright (C) 2024 Gabriel Cândido Ribeiro da Silva <gcrs2018@gmail.com> 
 * Copyright (C) 2024 Gustavo Rezende Gabriel <gustavorezendegabriel@hotmail.com>
 * Copyright (C) 2024 João Vitor Bier Barros <joaovitorbierbarros@gmail.com>
 * Copyright (C) 2024 Theo da Silva Sa <03silva.theo@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Swing;


import Model.City;
import Services.Read;
import Services.Update;
import Swing.Filters.LetterFilter;
import Swing.Filters.NumberOnlyFilter;
import Swing.Filters.NumberFilter;
import Utils.Ordenacoes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author Gabriel Cândido Ribeiro da Silva <gcrs2018@gmail.com>
 * @author Gustavo Rezende Gabriel <gustavorezendegabriel@hotmail.com>
 * @author João Vitor Bier Barros <joaovitorbierbarros@gmail.com>
 * @author Theo da Silva Sa <03silva.theo@gmail.com>
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() throws SQLException {
        initComponents();
   
        preencherTabela();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(TelaPrincipal.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        
        //Setando os filtros
        //((AbstractDocument) TextFieldBuscar.getDocument()).setDocumentFilter(new NumberOnlyFilter());
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        TextFieldBuscar = new javax.swing.JTextField();
        BuscarButton = new javax.swing.JButton();
        CreateButton = new javax.swing.JButton();
        EditarButton = new javax.swing.JButton();
        DeletarButton = new javax.swing.JButton();
        RelatorioButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        GraficoButton = new javax.swing.JButton();
        DetalhesButton = new javax.swing.JButton();
        ComboBox = new javax.swing.JComboBox<>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IBGE AnalytiQ");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código IBGE", "Municípios", "Microrregião", "Estado", "Região Geográfica", "Área Km²", "População", "Domicílios", "PIB Total (R$ mil)", "IDH", "Renda Média", "Renda Nominal", "PEA Dia", "IDH Educação", "IDH Longevidade", "Densidade Demográfica", "Classificação IDH", "PIB perCapta", "Última Alteração", "Classificação Edu", "Classificação Longe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table);

        TextFieldBuscar.setToolTipText("");

        BuscarButton.setBackground(new java.awt.Color(255, 79, 0));
        BuscarButton.setForeground(new java.awt.Color(255, 255, 255));
        BuscarButton.setText("Buscar");
        BuscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarButtonActionPerformed(evt);
            }
        });

        CreateButton.setBackground(new java.awt.Color(0, 102, 0));
        CreateButton.setForeground(new java.awt.Color(255, 255, 255));
        CreateButton.setText("Adicionar");
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });

        EditarButton.setBackground(new java.awt.Color(63, 75, 152));
        EditarButton.setForeground(new java.awt.Color(255, 255, 255));
        EditarButton.setText("Editar");
        EditarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarButtonActionPerformed(evt);
            }
        });

        DeletarButton.setBackground(new java.awt.Color(118, 0, 0));
        DeletarButton.setForeground(new java.awt.Color(255, 255, 255));
        DeletarButton.setText("Deletar");
        DeletarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarButtonActionPerformed(evt);
            }
        });

        RelatorioButton.setBackground(new java.awt.Color(0, 102, 102));
        RelatorioButton.setForeground(new java.awt.Color(255, 255, 255));
        RelatorioButton.setText("Relatório");
        RelatorioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar por Código IBGE ou Nome do Município");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IBGE_AnalytiQ_Logo2.png"))); // NOI18N

        GraficoButton.setBackground(new java.awt.Color(102, 0, 204));
        GraficoButton.setForeground(new java.awt.Color(255, 255, 255));
        GraficoButton.setText("Gráfico");
        GraficoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraficoButtonActionPerformed(evt);
            }
        });

        DetalhesButton.setText("Detalhes");
        DetalhesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetalhesButtonActionPerformed(evt);
            }
        });

        ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código IBGE", "Cidade", "Micro-Região", "Estado", "Região-Geográfica", "Area", "População", "Domicilios", "PIB Total", "IDH Geral", "Renda Média", "Renda Nominal", "PEA DIA", "IDH Educação", "IDH Longevidade" }));
        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TextFieldBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BuscarButton))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DetalhesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GraficoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RelatorioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CreateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeletarButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscarButton)
                            .addComponent(CreateButton)
                            .addComponent(EditarButton)
                            .addComponent(DeletarButton)
                            .addComponent(RelatorioButton)
                            .addComponent(GraficoButton)
                            .addComponent(DetalhesButton)
                            .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed
        Criar telaCriar = new Criar(this);
        telaCriar.setVisible(true);
        
    }//GEN-LAST:event_CreateButtonActionPerformed

    private void EditarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarButtonActionPerformed
        
        System.out.println("ENTREI NO EDITAR");
        
        Read read = new Read();
        Update update = new Update();
        
        int linhaSelecionada = Table.getSelectedRow();
        System.out.println("EU SEI QUAL A LINHA SELECIONADA, É A LINHA: "+linhaSelecionada);
       
        if(linhaSelecionada != -1){
            Object id = Table.getValueAt(linhaSelecionada,0);
            System.out.println("NA LINHA SELECIONADA EU VEJO QUE O ID DELA É DE:" + id.toString());
            int idNum = Integer.parseInt(id.toString());
            
            Editar telaEditar;
            try {
                telaEditar = new Editar(idNum, this);
                telaEditar.setVisible(true);
                //preencherTabela();
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        

        
    }//GEN-LAST:event_EditarButtonActionPerformed

    private void DeletarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarButtonActionPerformed

        int linhaSelecionada = Table.getSelectedRow();
        System.out.println("EU SEI QUAL A LINHA SELECIONADA, É A LINHA: "+linhaSelecionada);
        if(linhaSelecionada != -1){
            Object id = Table.getValueAt(linhaSelecionada,0);
            System.out.println("NA LINHA SELECIONADA EU VEJO QUE O ID DELA É DE:" + id.toString());
            //System.out.println("A VARIÁVEL idNum é do tipo: "+" E EU FIZ UM CASTING PARA QUE O VALOR NO idNum seja: " + idNum);
            int idNum = Integer.parseInt(id.toString());
            System.out.println("A VARIÁVEL idNum EU FIZ UM CASTING PARA QUE O VALOR NO idNum seja: " + idNum);

            Deletar telaDeletar = new Deletar(idNum, this);
            telaDeletar.setVisible(true);

        }
    }//GEN-LAST:event_DeletarButtonActionPerformed

    private void BuscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarButtonActionPerformed
        
        String input = TextFieldBuscar.getText().trim();
         
        //Verifica se tá vazio
        if(input.isEmpty()){
            JOptionPane.showMessageDialog(this, "Por favor, insira um Código IBGE ou nome do município para  para pesquisar.");
            return;
        }
        
        //Declara a tela de busca aqui encima mesmo
        //Buscar telaBuscar = null; SIMPLESMENTE O DETALHES É MELHOR
        Detalhes detalhes = null;
        if(input.matches("\\d+")){ //regex que confere se é um numero
            //é um id
            try {
                detalhes = new Detalhes(Integer.parseInt(input),this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            //é um nome
            try {
                detalhes = new Detalhes(input,this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        detalhes.setVisible(true);
    }//GEN-LAST:event_BuscarButtonActionPerformed

    private void RelatorioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioButtonActionPerformed

        Relatorio relatorio = null;
        try {
            relatorio = new Relatorio(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        relatorio.setVisible(true);
        
    }//GEN-LAST:event_RelatorioButtonActionPerformed

    private void GraficoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraficoButtonActionPerformed
        // TODO add your handling code here:
            LineChart example = new LineChart();
            example.setVisible(true);
    }//GEN-LAST:event_GraficoButtonActionPerformed

    private void DetalhesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetalhesButtonActionPerformed

        int linhaSelecionada = Table.getSelectedRow();
        System.out.println("EU SEI QUAL A LINHA SELECIONADA, É A LINHA: "+linhaSelecionada);
        if(linhaSelecionada != -1){
            Object id = Table.getValueAt(linhaSelecionada,0);
            System.out.println("NA LINHA SELECIONADA EU VEJO QUE O ID DELA É DE:" + id.toString());
            //System.out.println("A VARIÁVEL idNum é do tipo: "+" E EU FIZ UM CASTING PARA QUE O VALOR NO idNum seja: " + idNum);
            int idNum = Integer.parseInt(id.toString());
            System.out.println("A VARIÁVEL idNum EU FIZ UM CASTING PARA QUE O VALOR NO idNum seja: " + idNum);
            try {
                Detalhes detalhes= new Detalhes(idNum, this);
                detalhes.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
              }//GEN-LAST:event_DetalhesButtonActionPerformed

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        String opcaoOrdenacao = (String) ComboBox.getSelectedItem();
        
        switch(opcaoOrdenacao){
            case "Código IBGE": {
                try {
                    this.AtualizarTabelaOrdenando(Ordenacoes.ID);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            
            case "Cidade": {
                try {
                    this.AtualizarTabelaOrdenando(Ordenacoes.CIDADE);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            
            case "Micro-Região": {
                try {
                    this.AtualizarTabelaOrdenando(Ordenacoes.MICRO_REGIAO);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            
            case "Estado": {
                try {
                    this.AtualizarTabelaOrdenando(Ordenacoes.ESTADO);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            
            case "Região-Geográfica": {
                try {
                    this.AtualizarTabelaOrdenando(Ordenacoes.REGIAO_GEOGRAFICA);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            
            case "Area": {
                try {
                    this.AtualizarTabelaOrdenando(Ordenacoes.AREA_KM);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            
            case "População": {
                try {
                    this.AtualizarTabelaOrdenando(Ordenacoes.POPULACAO);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;            
            case "Domicilios": {
                try {
                    this.AtualizarTabelaOrdenando(Ordenacoes.DOMICILIOS);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case "PIB Total": {
                try {
                    this.AtualizarTabelaOrdenando(Ordenacoes.PIB_TOTAL);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case "IDH Geral": {
                try {
                    this.AtualizarTabelaOrdenando(Ordenacoes.IDH_GERAL);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "Renda Média": {
                try {
                    this.AtualizarTabelaOrdenando(Ordenacoes.RENDA_MEDIA);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case "Renda Nominal": {
                try {
                    this.AtualizarTabelaOrdenando(Ordenacoes.RENDA_NOMINAL);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;   
            case "PEA DIA": {
                try {
                    this.AtualizarTabelaOrdenando(Ordenacoes.PEA_DIA);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "IDH Educação": {
                try {
                    this.AtualizarTabelaOrdenando(Ordenacoes.IDH_EDUCACAO);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;  
            case "IDH Longevidade": {
                try {
                    this.AtualizarTabelaOrdenando(Ordenacoes.IDH_LONGEVIDADE);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;  
        }
        
        JOptionPane.showMessageDialog(this, "Foi ordenada por: " + opcaoOrdenacao);
    }//GEN-LAST:event_ComboBoxActionPerformed

    public void removeRow(int row){
        //lista.sizeList();
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        int linhaSelecionada = row;
        if(linhaSelecionada != -1){
            model.removeRow(Table.getSelectedRow());
            
            //Deletar telaDeletar = new Deletar(linhaSelecionada, this);
            //telaDeletar.setVisible(true);
        }
        
    }
    
    public void adicionarRow(City cidade){
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        Object rowData[] = new Object[21];

            rowData[0] = cidade.getId();
            rowData[1] = cidade.getMunicipio();
            rowData[2] = cidade.getMicroregiao();
            rowData[3] = cidade.getEstado();
            rowData[4] = cidade.getRegiaoGeografica();
            rowData[5] = cidade.getArea();
            rowData[6] = cidade.getPopulacao();
            rowData[7] = cidade.getDomicilios();
            rowData[8] = cidade.getPibTotal();
            rowData[9] = cidade.getIdh();
            rowData[10] = cidade.getRendaMedia();
            rowData[11] = cidade.getRendaNominal();
            rowData[12] = cidade.getPea();
            rowData[13] = cidade.getIdhEducacao();
            rowData[14] = cidade.getIdhLongevidade();
            rowData[15] = cidade.getDensidadeDemografica();
            rowData[16] = cidade.getClassficacaoIDH();
            rowData[17] = cidade.getPibPcTotal();
            rowData[18] = cidade.getUltimaAtualizacao();
            rowData[19] = cidade.getClassificacaoIDHEdu();
            rowData[20] = cidade.getClassificacaoIDHLongevidade();
            model.addRow(rowData);

    }
    
    public void preencherTabela() throws SQLException {
        
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        Read read = new Read();
        //ArrayList<City> cidades = lista.getCidades();
        ArrayList<City> cidades = read.buscarTodos();
        Object rowData[] = new Object[21];
         
        for(int i = 0; i < cidades.size(); i++){
            
            rowData[0] = cidades.get(i).getId();
            rowData[1] = cidades.get(i).getMunicipio();
            rowData[2] = cidades.get(i).getMicroregiao();
            rowData[3] = cidades.get(i).getEstado();
            rowData[4] = cidades.get(i).getRegiaoGeografica();
            rowData[5] = cidades.get(i).getArea();
            rowData[6] = cidades.get(i).getPopulacao();
            rowData[7] = cidades.get(i).getDomicilios();
            rowData[8] = cidades.get(i).getPibTotal();
            rowData[9] = cidades.get(i).getIdh();
            rowData[10] = cidades.get(i).getRendaMedia();
            rowData[11] = cidades.get(i).getRendaNominal();
            rowData[12] = cidades.get(i).getPea();
            rowData[13] = cidades.get(i).getIdhEducacao();
            rowData[14] = cidades.get(i).getIdhLongevidade();
            rowData[15] = cidades.get(i).getDensidadeDemografica();
            rowData[16] = cidades.get(i).getClassficacaoIDH();
            rowData[17] = cidades.get(i).getPibPcTotal();
            rowData[18] = cidades.get(i).getUltimaAtualizacao();
            rowData[19] = cidades.get(i).getClassificacaoIDHEdu();
            rowData[20] = cidades.get(i).getClassificacaoIDHLongevidade();
            model.addRow(rowData);
        }
        
        /*
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(Table.getModel());
        Table.setRowSorter(sorter);
        */ //está bugando por enquanto
    }
    
    public void AtualizarTabela() throws SQLException {
    DefaultTableModel model = (DefaultTableModel) Table.getModel();

    // Limpar a tabela antes de adicionar novas linhas
    model.setRowCount(0); // Limpa as linhas da tabela

    Read read = new Read();
    ArrayList<City> cidades = read.buscarTodos();
    Object rowData[] = new Object[21];
         
        for (int i = 0; i < cidades.size(); i++) {
            rowData[0] = cidades.get(i).getId();
            rowData[1] = cidades.get(i).getMunicipio();
            rowData[2] = cidades.get(i).getMicroregiao();
            rowData[3] = cidades.get(i).getEstado();
            rowData[4] = cidades.get(i).getRegiaoGeografica();
            rowData[5] = cidades.get(i).getArea();
            rowData[6] = cidades.get(i).getPopulacao();
            rowData[7] = cidades.get(i).getDomicilios();
            rowData[8] = cidades.get(i).getPibTotal();
            rowData[9] = cidades.get(i).getIdh();
            rowData[10] = cidades.get(i).getRendaMedia();
            rowData[11] = cidades.get(i).getRendaNominal();
            rowData[12] = cidades.get(i).getPea();
            rowData[13] = cidades.get(i).getIdhEducacao();
            rowData[14] = cidades.get(i).getIdhLongevidade();
            rowData[15] = cidades.get(i).getDensidadeDemografica();
            rowData[16] = cidades.get(i).getClassficacaoIDH();
            rowData[17] = cidades.get(i).getPibPcTotal();
            rowData[18] = cidades.get(i).getUltimaAtualizacao();
            rowData[19] = cidades.get(i).getClassificacaoIDHEdu();
            rowData[20] = cidades.get(i).getClassificacaoIDHLongevidade();
            model.addRow(rowData);
        }
    }
    
    public void AtualizarTabelaOrdenando(Ordenacoes ordenacao) throws SQLException {
    DefaultTableModel model = (DefaultTableModel) Table.getModel();

    // Limpar a tabela antes de adicionar novas linhas
    model.setRowCount(0); // Limpa as linhas da tabela

    Read read = new Read();
    ArrayList<City> cidades = read.buscarOrdenado(ordenacao);
    Object rowData[] = new Object[21];
         
        for (int i = 0; i < cidades.size(); i++) {
            rowData[0] = cidades.get(i).getId();
            rowData[1] = cidades.get(i).getMunicipio();
            rowData[2] = cidades.get(i).getMicroregiao();
            rowData[3] = cidades.get(i).getEstado();
            rowData[4] = cidades.get(i).getRegiaoGeografica();
            rowData[5] = cidades.get(i).getArea();
            rowData[6] = cidades.get(i).getPopulacao();
            rowData[7] = cidades.get(i).getDomicilios();
            rowData[8] = cidades.get(i).getPibTotal();
            rowData[9] = cidades.get(i).getIdh();
            rowData[10] = cidades.get(i).getRendaMedia();
            rowData[11] = cidades.get(i).getRendaNominal();
            rowData[12] = cidades.get(i).getPea();
            rowData[13] = cidades.get(i).getIdhEducacao();
            rowData[14] = cidades.get(i).getIdhLongevidade();
            rowData[15] = cidades.get(i).getDensidadeDemografica();
            rowData[16] = cidades.get(i).getClassficacaoIDH();
            rowData[17] = cidades.get(i).getPibPcTotal();
            rowData[18] = cidades.get(i).getUltimaAtualizacao();
            rowData[19] = cidades.get(i).getClassificacaoIDHEdu();
            rowData[20] = cidades.get(i).getClassificacaoIDHLongevidade();
            model.addRow(rowData);
        }
    }

    public void MostrarApenasUm(City cidade) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();

    // Limpar a tabela antes de adicionar novas linhas
        model.setRowCount(0); // Limpa as linhas da tabela

        Object rowData[] = new Object[21];
        rowData[0] = cidade.getId();
        rowData[1] = cidade.getMunicipio();
        rowData[2] = cidade.getMicroregiao();
        rowData[3] = cidade.getEstado();
        rowData[4] = cidade.getRegiaoGeografica();
        rowData[5] = cidade.getArea();
        rowData[6] = cidade.getPopulacao();
        rowData[7] = cidade.getDomicilios();
        rowData[8] = cidade.getPibTotal();
        rowData[9] = cidade.getIdh();
        rowData[10] = cidade.getRendaMedia();
        rowData[11] = cidade.getRendaNominal();
        rowData[12] = cidade.getPea();
        rowData[13] = cidade.getIdhEducacao();
        rowData[14] = cidade.getIdhLongevidade();
        rowData[15] = cidade.getDensidadeDemografica();
        rowData[16] = cidade.getClassficacaoIDH();
        rowData[17] = cidade.getPibPcTotal();
        rowData[18] = cidade.getUltimaAtualizacao();
        rowData[19] = cidade.getClassificacaoIDHEdu();
        rowData[20] = cidade.getClassificacaoIDHLongevidade(); 
        model.addRow(rowData);

    }
    
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarButton;
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JButton CreateButton;
    private javax.swing.JButton DeletarButton;
    private javax.swing.JButton DetalhesButton;
    private javax.swing.JButton EditarButton;
    private javax.swing.JButton GraficoButton;
    private javax.swing.JButton RelatorioButton;
    private javax.swing.JTable Table;
    private javax.swing.JTextField TextFieldBuscar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
