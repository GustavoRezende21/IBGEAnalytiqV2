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
import Services.Create;
import Services.Read;
import Services.Update;
import Utils.Ordenacoes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Cândido Ribeiro da Silva <gcrs2018@gmail.com>
 * @author Gustavo Rezende Gabriel <gustavorezendegabriel@hotmail.com>
 * @author João Vitor Bier Barros <joaovitorbierbarros@gmail.com>
 * @author Theo da Silva Sa <03silva.theo@gmail.com>
 */
public class Detalhes extends javax.swing.JFrame {
    /**
     * Creates new form Edicao
     */
    TelaPrincipal telaPrincipal;
    City cidade;
    
    public Detalhes(City cidade) throws SQLException {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(Detalhes.DISPOSE_ON_CLOSE);
        this.cidade = cidade;
        
        //inicializa a lista aqui já
        //lista = new Lista();
        
        //atualiza a lista pra garantir que ela tá igual
        //lista.atualizarLista();
        
        String Pib = rankingPIB(cidade);
        String IDH = rankingIDH(cidade);
        System.out.println("Ranking do PIB:"+Pib);
        System.out.println("Ranking do IDH:"+IDH);
        //ArrayList<City> cidades = lista.getCidades();
        
        
       
        System.out.println(cidade.toString());
        
        //Preenchendo os textfield
        idField.setText(cidade.getId());
        municipioField.setText(cidade.getMunicipio());
        estadoField.setText(cidade.getEstado());
        microRegiaoField.setText(cidade.getMicroregiao());
        regiaoGeograficaField.setText(cidade.getRegiaoGeografica());
        areaField.setText(String.valueOf(cidade.getArea()));
        populacaoField.setText(String.valueOf(cidade.getPopulacao()));
        domiciliosField.setText(String.valueOf(cidade.getDomicilios()));
        pibTotalField.setText(String.valueOf(cidade.getPibTotal()));        
        idhField.setText(String.valueOf(cidade.getIdh()));        
        rendaMediaField.setText(String.valueOf(cidade.getRendaMedia()));        
        rendaNominalField.setText(String.valueOf(cidade.getRendaNominal()));
        peaField.setText(String.valueOf(cidade.getPea()));        
        idhEduca.setText(String.valueOf(cidade.getIdhEducacao()));
        idhLonge.setText(String.valueOf(cidade.getIdhLongevidade()));
        jTextFieldRankingPib.setText(Pib);
        jTextFieldRankingIDH.setText(IDH);
    }
    
    public Detalhes(int id) throws SQLException {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(Detalhes.DISPOSE_ON_CLOSE);
        Read read = new Read();
        this.cidade = read.consultarPorId(id);
        //inicializa a lista aqui já
        //lista = new Lista();
        
        //atualiza a lista pra garantir que ela tá igual
        //lista.atualizarLista();
        
        String Pib = rankingPIB(cidade);
        String IDH = rankingIDH(cidade);
        System.out.println("Ranking do PIB:"+Pib);
        System.out.println("Ranking do IDH:"+IDH);
        //ArrayList<City> cidades = lista.getCidades();
        
        
       
        System.out.println(cidade.toString());
        
        //Preenchendo os textfield
        idField.setText(cidade.getId());
        municipioField.setText(cidade.getMunicipio());
        estadoField.setText(cidade.getEstado());
        microRegiaoField.setText(cidade.getMicroregiao());
        regiaoGeograficaField.setText(cidade.getRegiaoGeografica());
        areaField.setText(String.valueOf(cidade.getArea()));
        populacaoField.setText(String.valueOf(cidade.getPopulacao()));
        domiciliosField.setText(String.valueOf(cidade.getDomicilios()));
        pibTotalField.setText(String.valueOf(cidade.getPibTotal()));        
        idhField.setText(String.valueOf(cidade.getIdh()));        
        rendaMediaField.setText(String.valueOf(cidade.getRendaMedia()));        
        rendaNominalField.setText(String.valueOf(cidade.getRendaNominal()));
        peaField.setText(String.valueOf(cidade.getPea()));        
        idhEduca.setText(String.valueOf(cidade.getIdhEducacao()));
        idhLonge.setText(String.valueOf(cidade.getIdhLongevidade()));
        jTextFieldRankingPib.setText(Pib);
        jTextFieldRankingIDH.setText(IDH);
    }
        
    public Detalhes(String municipio) throws SQLException {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(Detalhes.DISPOSE_ON_CLOSE);
        Read read = new Read();
        this.cidade = read.consultarPorNome(municipio);
        //inicializa a lista aqui já
        //lista = new Lista();
        
        //atualiza a lista pra garantir que ela tá igual
        //lista.atualizarLista();
        
        String Pib = rankingPIB(cidade);
        String IDH = rankingIDH(cidade);
        System.out.println("Ranking do PIB:"+Pib);
        System.out.println("Ranking do IDH:"+IDH);
        //ArrayList<City> cidades = lista.getCidades();
        
        
       
        System.out.println(cidade.toString());
        
        //Preenchendo os textfield
        idField.setText(cidade.getId());
        municipioField.setText(cidade.getMunicipio());
        estadoField.setText(cidade.getEstado());
        microRegiaoField.setText(cidade.getMicroregiao());
        regiaoGeograficaField.setText(cidade.getRegiaoGeografica());
        areaField.setText(String.valueOf(cidade.getArea()));
        populacaoField.setText(String.valueOf(cidade.getPopulacao()));
        domiciliosField.setText(String.valueOf(cidade.getDomicilios()));
        pibTotalField.setText(String.valueOf(cidade.getPibTotal()));        
        idhField.setText(String.valueOf(cidade.getIdh()));        
        rendaMediaField.setText(String.valueOf(cidade.getRendaMedia()));        
        rendaNominalField.setText(String.valueOf(cidade.getRendaNominal()));
        peaField.setText(String.valueOf(cidade.getPea()));        
        idhEduca.setText(String.valueOf(cidade.getIdhEducacao()));
        idhLonge.setText(String.valueOf(cidade.getIdhLongevidade()));
        jTextFieldRankingPib.setText(Pib);
        jTextFieldRankingIDH.setText(IDH);
    }        
      
    public Detalhes(City cidade, TelaPrincipal telaPrincipal) throws SQLException {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(Detalhes.DISPOSE_ON_CLOSE);
        this.telaPrincipal = telaPrincipal;
        this.cidade = cidade;
        //inicializa a lista aqui já
        //lista = new Lista();
        
        //atualiza a lista pra garantir que ela tá igual
        //lista.atualizarLista();
        
        String Pib = rankingPIB(cidade);
        String IDH = rankingIDH(cidade);
        System.out.println("Ranking do PIB:"+Pib);
        System.out.println("Ranking do IDH:"+IDH);
        //ArrayList<City> cidades = lista.getCidades();
        
        
       
        System.out.println(cidade.toString());
        
        //Preenchendo os textfield
        idField.setText(cidade.getId());
        municipioField.setText(cidade.getMunicipio());
        estadoField.setText(cidade.getEstado());
        microRegiaoField.setText(cidade.getMicroregiao());
        regiaoGeograficaField.setText(cidade.getRegiaoGeografica());
        areaField.setText(String.valueOf(cidade.getArea()));
        populacaoField.setText(String.valueOf(cidade.getPopulacao()));
        domiciliosField.setText(String.valueOf(cidade.getDomicilios()));
        pibTotalField.setText(String.valueOf(cidade.getPibTotal()));        
        idhField.setText(String.valueOf(cidade.getIdh()));        
        rendaMediaField.setText(String.valueOf(cidade.getRendaMedia()));        
        rendaNominalField.setText(String.valueOf(cidade.getRendaNominal()));
        peaField.setText(String.valueOf(cidade.getPea()));        
        idhEduca.setText(String.valueOf(cidade.getIdhEducacao()));
        idhLonge.setText(String.valueOf(cidade.getIdhLongevidade()));
        jTextFieldRankingPib.setText(Pib);
        jTextFieldRankingIDH.setText(IDH);
    }
    
    public Detalhes(int id, TelaPrincipal telaPrincipal) throws SQLException {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(Detalhes.DISPOSE_ON_CLOSE);
        Read read = new Read();
        this.cidade = read.consultarPorId(id);
        this.telaPrincipal = telaPrincipal;
        //inicializa a lista aqui já
        //lista = new Lista();
        
        //atualiza a lista pra garantir que ela tá igual
        //lista.atualizarLista();
        
        String Pib = rankingPIB(cidade);
        String IDH = rankingIDH(cidade);
        System.out.println("Ranking do PIB:"+Pib);
        System.out.println("Ranking do IDH:"+IDH);
        //ArrayList<City> cidades = lista.getCidades();
        
        
       
        System.out.println(cidade.toString());
        
        //Preenchendo os textfield
        idField.setText(cidade.getId());
        municipioField.setText(cidade.getMunicipio());
        estadoField.setText(cidade.getEstado());
        microRegiaoField.setText(cidade.getMicroregiao());
        regiaoGeograficaField.setText(cidade.getRegiaoGeografica());
        areaField.setText(String.valueOf(cidade.getArea()));
        populacaoField.setText(String.valueOf(cidade.getPopulacao()));
        domiciliosField.setText(String.valueOf(cidade.getDomicilios()));
        pibTotalField.setText(String.valueOf(cidade.getPibTotal()));        
        idhField.setText(String.valueOf(cidade.getIdh()));        
        rendaMediaField.setText(String.valueOf(cidade.getRendaMedia()));        
        rendaNominalField.setText(String.valueOf(cidade.getRendaNominal()));
        peaField.setText(String.valueOf(cidade.getPea()));        
        idhEduca.setText(String.valueOf(cidade.getIdhEducacao()));
        idhLonge.setText(String.valueOf(cidade.getIdhLongevidade()));
        jTextFieldRankingPib.setText(Pib);
        jTextFieldRankingIDH.setText(IDH);
    }

    public Detalhes(String municipio, TelaPrincipal telaPrincipal) throws SQLException {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(Detalhes.DISPOSE_ON_CLOSE);
        Read read = new Read();
        this.cidade = read.consultarPorNome(municipio);
        this.telaPrincipal = telaPrincipal;
        //inicializa a lista aqui já
        //lista = new Lista();
        
        //atualiza a lista pra garantir que ela tá igual
        //lista.atualizarLista();
        
        String Pib = rankingPIB(cidade);
        String IDH = rankingIDH(cidade);
        System.out.println("Ranking do PIB:"+Pib);
        System.out.println("Ranking do IDH:"+IDH);
        //ArrayList<City> cidades = lista.getCidades();
        
        System.out.println(cidade.toString());
        
        //Preenchendo os textfield
        idField.setText(cidade.getId());
        municipioField.setText(cidade.getMunicipio());
        estadoField.setText(cidade.getEstado());
        microRegiaoField.setText(cidade.getMicroregiao());
        regiaoGeograficaField.setText(cidade.getRegiaoGeografica());
        areaField.setText(String.valueOf(cidade.getArea()));
        populacaoField.setText(String.valueOf(cidade.getPopulacao()));
        domiciliosField.setText(String.valueOf(cidade.getDomicilios()));
        pibTotalField.setText(String.valueOf(cidade.getPibTotal()));        
        idhField.setText(String.valueOf(cidade.getIdh()));        
        rendaMediaField.setText(String.valueOf(cidade.getRendaMedia()));        
        rendaNominalField.setText(String.valueOf(cidade.getRendaNominal()));
        peaField.setText(String.valueOf(cidade.getPea()));        
        idhEduca.setText(String.valueOf(cidade.getIdhEducacao()));
        idhLonge.setText(String.valueOf(cidade.getIdhLongevidade()));
        jTextFieldRankingPib.setText(Pib);
        jTextFieldRankingIDH.setText(IDH);
    }        
        
    private String rankingIDH(City cidade) throws SQLException{
        
        String posicao = "";
        System.out.println(cidade.toString());
        try {
            Read read = new Read();
            ArrayList<City> cidades = read.buscarTodos();
            if(!cidades.isEmpty()){
                System.out.println("NÃO ESTOU VAZIA, TENHO "+cidades.size()+" ELEMENTOS");
            }
            //ORDENANDO COM BOOBLE SORT!
            int n = cidades.size();
            boolean swapped;
            for (int i = 0; i < n - 1; i++) {
                swapped = false;

                for (int j = 0; j < n - i - 1; j++) {
                    // Compara os valores de pibPcTotal
                    if (cidades.get(j).getIdh()> cidades.get(j + 1).getIdh()) {
                        // Troca os elementos
                        City temp = cidades.get(j);
                        cidades.set(j, cidades.get(j + 1));
                        cidades.set(j + 1, temp);
                        swapped = true;
                    }
                }

                // Se nenhuma troca ocorreu, a lista já está ordenada
                if (!swapped) break;
            }
            
            
            //AGORA BUSCA A CIDADE NA LISTA ORDENADA
            for(int i = 0; i < cidades.size(); i++){
                if(cidade.getId() == null ? cidades.get(i).getId() == null : cidade.getId().equals(cidades.get(i).getId())){
                    posicao = Integer.toString(i);
                    System.out.println("A POSIÇÃO NO RANKING DA CIDADE DE PROCURADA É DE: "+cidade.getId()+" SENDO O ID ACHADO DELA NA LISTA ORDENADA TBM SER "+ cidades.get(i).getId());
                    System.out.println("E SUA POSIÇÃO É NA POSIÇÃO: "+ posicao);
                }
            }
            
            return posicao;
            
        }catch (SQLException ex) {
            Logger.getLogger(Detalhes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    private String rankingPIB(City cidade){
        
        String posicao = "";
        System.out.println(cidade.toString());
        try {
            Read read = new Read();
            ArrayList<City> cidades = read.buscarTodos();
            if(!cidades.isEmpty()){
                System.out.println("NÃO ESTOU VAZIA, TENHO "+cidades.size()+" ELEMENTOS");
            }
            
            //SORT COM SELECTION SORT
            int n = cidades.size();
            for (int i = 0; i < n - 1; i++) {
                // Encontra o índice do menor elemento no restante do array
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (cidades.get(j).getPibPcTotal() < cidades.get(minIndex).getPibPcTotal()) {
                        minIndex = j;
                    }
                }
                // Troca o menor elemento encontrado com o elemento na posição atual
                if (minIndex != i) {
                    City temp = cidades.get(i);
                    cidades.set(i, cidades.get(minIndex));
                    cidades.set(minIndex, temp);
                }
            }
            
            //AGORA BUSCA A CIDADE NA LISTA ORDENADA
            for(int i = 0; i < cidades.size(); i++){
                if(cidade.getId() == null ? cidades.get(i).getId() == null : cidade.getId().equals(cidades.get(i).getId())){
                    posicao = Integer.toString(i);
                    System.out.println("A POSIÇÃO NO RANKING DA CIDADE DE PROCURADA É DE: "+cidade.getId()+" SENDO O ID ACHADO DELA NA LISTA ORDENADA TBM SER "+ cidades.get(i).getId());
                    System.out.println("E SUA POSIÇÃO É NA POSIÇÃO: "+ posicao);
                }
            }            
            return posicao;
           
        }catch (SQLException ex) {
            Logger.getLogger(Detalhes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
        
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel16 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        municipioField = new javax.swing.JTextField();
        estadoField = new javax.swing.JTextField();
        regiaoGeograficaField = new javax.swing.JTextField();
        areaField = new javax.swing.JTextField();
        populacaoField = new javax.swing.JTextField();
        domiciliosField = new javax.swing.JTextField();
        pibTotalField = new javax.swing.JTextField();
        idhField = new javax.swing.JTextField();
        rendaMediaField = new javax.swing.JTextField();
        rendaNominalField = new javax.swing.JTextField();
        peaField = new javax.swing.JTextField();
        idhEduca = new javax.swing.JTextField();
        idhLonge = new javax.swing.JTextField();
        FecharButton = new javax.swing.JButton();
        microRegiaoField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldRankingPib = new javax.swing.JTextField();
        jTextFieldRankingIDH = new javax.swing.JTextField();
        DeletarButton = new javax.swing.JButton();
        EditarButton = new javax.swing.JButton();

        jLabel16.setText("jLabel16");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Detalhes");

        idField.setEditable(false);

        municipioField.setEditable(false);

        estadoField.setEditable(false);

        regiaoGeograficaField.setEditable(false);

        areaField.setEditable(false);

        populacaoField.setEditable(false);

        domiciliosField.setEditable(false);

        pibTotalField.setEditable(false);

        idhField.setEditable(false);

        rendaMediaField.setEditable(false);

        rendaNominalField.setEditable(false);

        peaField.setEditable(false);

        idhEduca.setEditable(false);
        idhEduca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idhEducaActionPerformed(evt);
            }
        });

        idhLonge.setEditable(false);

        FecharButton.setText("Fechar");
        FecharButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FecharButtonActionPerformed(evt);
            }
        });

        microRegiaoField.setEditable(false);

        jLabel1.setText("Código IBGE");

        jLabel2.setText("Município");

        jLabel3.setText("Microregião");

        jLabel4.setText("Estado");

        jLabel5.setText("Regiao Geográfica");

        jLabel6.setText("Área Km²");

        jLabel7.setText("População");

        jLabel8.setText("Domicílios");

        jLabel9.setText("PIB Total (R$ mil)");

        jLabel10.setText("IDH");

        jLabel11.setText("Renda Média");

        jLabel12.setText("Renda Nominal");

        jLabel13.setText("PEA Dia");

        jLabel14.setText("IDH Educação");

        jLabel15.setText("IDH Longevidade");

        jLabel17.setText("Ranking no PIB Per Capta");

        jLabel18.setText("Ranking no IDH Geral");

        jTextFieldRankingPib.setEditable(false);

        jTextFieldRankingIDH.setEditable(false);

        DeletarButton.setText("Deletar");
        DeletarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarButtonActionPerformed(evt);
            }
        });

        EditarButton.setText("Editar");
        EditarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DeletarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditarButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(regiaoGeograficaField)
                            .addComponent(estadoField)
                            .addComponent(microRegiaoField)
                            .addComponent(municipioField)
                            .addComponent(idField)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldRankingPib))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(areaField)
                                .addComponent(populacaoField)
                                .addComponent(domiciliosField)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(idhField)
                                .addComponent(pibTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldRankingIDH, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(idhEduca, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(peaField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(rendaNominalField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(rendaMediaField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(idhLonge, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FecharButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(areaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rendaMediaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(5, 5, 5)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel14))
                                    .addGap(2, 2, 2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pibTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(idhEduca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel15))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(idhField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(idhLonge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(populacaoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rendaNominalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(148, 148, 148))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(31, 31, 31)
                            .addComponent(jLabel7)
                            .addGap(37, 37, 37)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel13))
                            .addGap(3, 3, 3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(domiciliosField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(peaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(municipioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)
                        .addComponent(microRegiaoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(estadoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regiaoGeograficaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldRankingIDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldRankingPib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FecharButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeletarButton)
                    .addComponent(EditarButton))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idhEducaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idhEducaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idhEducaActionPerformed

    private void FecharButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharButtonActionPerformed
        
        //Update update = new Update();
        
        /*        
        String id = idField.getText();
        String municipio = municipioField.getText();
        String estado = estadoField.getText();
        String microRegiao = microRegiaoField.getText();
        String regiaoGeografica = regiaoGeograficaField.getText();
        double area = Double.parseDouble(areaField.getText());
        double populacao = Double.parseDouble(populacaoField.getText());
        double domicilios = Double.parseDouble(domiciliosField.getText());
        double pibTotal = Double.parseDouble(pibTotalField.getText());
        double idh = Double.parseDouble(idhField.getText());
        double rendaMedia = Double.parseDouble(rendaMediaField.getText());
        double rendaNominal = Double.parseDouble(rendaNominalField.getText());
        double pea = Double.parseDouble(peaField.getText());
        double idhEducacao = Double.parseDouble(idhEduca.getText());
        double idhLongevidade = Double.parseDouble(idhLonge.getText());
        //double densidadeDemografica = Double.parseDouble(Field.getText());
        //double pibTotal = Double.parseDouble(Field.getText());
        //String classificacaoIDH;
        //String pibPcTotal;
        
        
        City cidade = new City(
                id,
                municipio,
                microRegiao,
                estado,
                regiaoGeografica,
                area,
                populacao,
                domicilios,
                pibTotal,
                idh,
                rendaMedia,
                rendaNominal,
                pea,
                idhEducacao,
                idhLongevidade
        );
        String idUpdate = String.valueOf(indexDaCidadeBuscada);
        update.UpdateById(idUpdate ,this.lista, cidade);
        */
        dispose();
        
        //update.UpdateById(i, lista, cidadeEditar);
    }//GEN-LAST:event_FecharButtonActionPerformed

    private void DeletarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarButtonActionPerformed
        
        int idCidade = Integer.parseInt(this.cidade.getId());
        
        Deletar telaDeletar = new Deletar(idCidade, this.telaPrincipal);
        telaDeletar.setVisible(true);
        dispose();

    }//GEN-LAST:event_DeletarButtonActionPerformed

    private void EditarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarButtonActionPerformed
        int idCidade = Integer.parseInt(this.cidade.getId());
        try {
            Editar telaEditar = new Editar(idCidade, this.telaPrincipal);
            telaEditar.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Detalhes.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_EditarButtonActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeletarButton;
    private javax.swing.JButton EditarButton;
    private javax.swing.JButton FecharButton;
    private javax.swing.JTextField areaField;
    private javax.swing.JTextField domiciliosField;
    private javax.swing.JTextField estadoField;
    private javax.swing.JTextField idField;
    private javax.swing.JTextField idhEduca;
    private javax.swing.JTextField idhField;
    private javax.swing.JTextField idhLonge;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldRankingIDH;
    private javax.swing.JTextField jTextFieldRankingPib;
    private javax.swing.JTextField microRegiaoField;
    private javax.swing.JTextField municipioField;
    private javax.swing.JTextField peaField;
    private javax.swing.JTextField pibTotalField;
    private javax.swing.JTextField populacaoField;
    private javax.swing.JTextField regiaoGeograficaField;
    private javax.swing.JTextField rendaMediaField;
    private javax.swing.JTextField rendaNominalField;
    // End of variables declaration//GEN-END:variables
}
