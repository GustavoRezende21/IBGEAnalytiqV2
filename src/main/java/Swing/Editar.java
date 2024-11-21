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
import Services.Delete;
import Services.Lista;
import Services.Update;
import Swing.Filters.LetterFilter;
import Swing.Filters.NumberFilter;
import Swing.Filters.NumberOnlyFilter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author Gabriel Cândido Ribeiro da Silva <gcrs2018@gmail.com>
 * @author Gustavo Rezende Gabriel <gustavorezendegabriel@hotmail.com>
 * @author João Vitor Bier Barros <joaovitorbierbarros@gmail.com>
 * @author Theo da Silva Sa <03silva.theo@gmail.com>
 */
public class Editar extends javax.swing.JFrame {

    /**
     * Creates new form Edicao
     */
    int indexDaCidadeEditada;
    Lista lista;
    TelaPrincipal telaPrincipal;
    City cidadeEditar;
    public Editar(int idex, Lista lista, TelaPrincipal telaPrincipal) {
     
        this.telaPrincipal = telaPrincipal;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(Editar.DISPOSE_ON_CLOSE);
        
        this.indexDaCidadeEditada = idex;
        
        //declara a lista aqui já
        this.lista = lista;
        
        //atualiza a lista pra garantir que ela tá igual
        //lista.atualizarLista();
      
        //monta a cidade que vai ser editada
        cidadeEditar = lista.getCidades().get(indexDaCidadeEditada);
        
        //Preenchendo os textfield
        idField.setText(cidadeEditar.getId());
        municipioField.setText(cidadeEditar.getMunicipio());
        estadoField.setText(cidadeEditar.getEstado());
        microRegiaoField.setText(cidadeEditar.getMicroregiao());
        regiaoGeograficaField.setText(cidadeEditar.getRegiaoGeografica());
        areaField.setText(String.valueOf(cidadeEditar.getArea()));
        populacaoField.setText(String.valueOf(cidadeEditar.getPopulacao()));
        domiciliosField.setText(String.valueOf(cidadeEditar.getDomicilios()));
        pibTotalField.setText(String.valueOf(cidadeEditar.getPibTotal()));        
        idhField.setText(String.valueOf(cidadeEditar.getIdh()));        
        rendaMediaField.setText(String.valueOf(cidadeEditar.getRendaMedia()));        
        rendaNominalField.setText(String.valueOf(cidadeEditar.getRendaNominal()));
        peaField.setText(String.valueOf(cidadeEditar.getPea()));        
        idhEduca.setText(String.valueOf(cidadeEditar.getIdhEducacao()));
        idhLonge.setText(String.valueOf(cidadeEditar.getIdhLongevidade()));
        
        //Setando os filtros
        ((AbstractDocument) idField.getDocument()).setDocumentFilter(new NumberOnlyFilter());
        ((AbstractDocument) municipioField.getDocument()).setDocumentFilter(new LetterFilter());
        ((AbstractDocument) microRegiaoField.getDocument()).setDocumentFilter(new LetterFilter());
        ((AbstractDocument) estadoField.getDocument()).setDocumentFilter(new LetterFilter());
        ((AbstractDocument) regiaoGeograficaField.getDocument()).setDocumentFilter(new LetterFilter());
        ((AbstractDocument) areaField.getDocument()).setDocumentFilter(new NumberFilter());
        ((AbstractDocument) populacaoField.getDocument()).setDocumentFilter(new NumberFilter());
        ((AbstractDocument) domiciliosField.getDocument()).setDocumentFilter(new NumberFilter());
        ((AbstractDocument) pibTotalField.getDocument()).setDocumentFilter(new NumberFilter());
        ((AbstractDocument) idhField.getDocument()).setDocumentFilter(new NumberFilter());
        ((AbstractDocument) rendaMediaField.getDocument()).setDocumentFilter(new NumberFilter());
        ((AbstractDocument) rendaNominalField.getDocument()).setDocumentFilter(new NumberFilter());
        ((AbstractDocument) peaField.getDocument()).setDocumentFilter(new NumberFilter());
        ((AbstractDocument) idhEduca.getDocument()).setDocumentFilter(new NumberFilter());
        ((AbstractDocument) idhLonge.getDocument()).setDocumentFilter(new NumberFilter());
        
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
        jButton1 = new javax.swing.JButton();
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

        jLabel16.setText("jLabel16");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editar");

        idField.setEditable(false);

        municipioField.setEditable(false);

        estadoField.setEditable(false);

        regiaoGeograficaField.setEditable(false);

        idhEduca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idhEducaActionPerformed(evt);
            }
        });

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
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
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
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
                            .addComponent(idhLonge, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 44, Short.MAX_VALUE))
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
                .addComponent(jButton1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idhEducaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idhEducaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idhEducaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Delete delete = new Delete();
        Create create = new Create();
        
        delete.DeleteById(indexDaCidadeEditada, lista);
        this.telaPrincipal.removeRow(indexDaCidadeEditada);
        
                
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
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = agora.format(formatador);
        
        
        
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
        cidade.setUltimaAtualizacao(dataHoraFormatada);
        System.out.println(cidade.toCSVOut());
        
        create.createCity(lista, cidade);
        telaPrincipal.adicionarRow(cidade);
        dispose();
        
        //update.UpdateById(i, lista, cidadeEditar);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areaField;
    private javax.swing.JTextField domiciliosField;
    private javax.swing.JTextField estadoField;
    private javax.swing.JTextField idField;
    private javax.swing.JTextField idhEduca;
    private javax.swing.JTextField idhField;
    private javax.swing.JTextField idhLonge;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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