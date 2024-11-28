/*
 * Copyright (C) 2024 notebook
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
package Dao;

import static Dao.DataAcessObject.conexao;
import Model.City;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author notebook
 */
public class DAO_Adicionar implements DataAcessObject {

    public boolean adicionar(City cidade) throws SQLException {
        Connection connection = conexao.conectar();
        //É usado para criar um objeto que representa a instrução SQL que será executada
        //Função invocada atraves da Connection
        //Statement statement = connection.createStatement();
        /*
        ResultSet resultado = statement.executeQuery("INSERT INTO cidade (id, cidade,"
                + " microregiao, estado, regiaogeografica, areakm, populacao,"
                + " domicilios, pibTotal, idh_geral, renda_media, renda_nominal, pea_dia,"
                + " idh_educacao, idh_longevidade) VALUES (?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?)";
         */
        String sql = "INSERT INTO cidade (id, cidade,"
                + " microregiao, estado, regiaogeografica, areakm, populacao,"
                + " domicilios, pib_total, idh_geral, renda_media, renda_nominal, pea_dia,"
                + " idh_educacao, idh_longevidade) VALUES (?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?);";
        
        System.out.println("EXECUTED QUERY IS");
        System.out.println(sql);
        //É usado para criar um objeto que representa a instrução SQL que será executada
        //Função invocada atraves da Connection
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            /*
            String linha;
            while ((linha = reader.readLine()) != null) {
                linha = linha.replaceAll("\"", "");
                String[] elementos = linha.split(";");
             */
 /* int id = Integer.parseInt(pstmt[0]);
                String cidade = pstmt[1];
                String microregiao = pstmt[2];
                String estado = pstmt[3];
                String regiaogeografica = pstmt[4];
                double areakm = Double.parseDouble(pstmt[5]);
                int populacao = (int) Double.parseDouble(pstmt[6]);
                double domicilios = Double.parseDouble(pstmt[7]);
                double pib_total = Double.parseDouble(pstmt[8]);
                double idh_geral = Double.parseDouble(pstmt[9]);
                double renda_media = Double.parseDouble(pstmt[10]);
                double renda_nominal = Double.parseDouble(pstmt[11]);
                double pea_dia = Double.parseDouble(pstmt[12]);
                double idh_educacao = Double.parseDouble(pstmt[13]);
                double idh_longevidade = Double.parseDouble(pstmt[14]);
             */
            //City city = new City(id,cidade,microregiao,estado,regiaogeografica,"
            //+"areakm,populacao,domicilios,pibTotal,idh_geral,renda_media,renda_nominal,pea_dia,idh_educacao,idh_longevidade);
            pstmt.setInt(1, Integer.parseInt(cidade.getId()));
            pstmt.setString(2, cidade.getMunicipio());
            pstmt.setString(3, cidade.getMicroregiao());
            pstmt.setString(4, cidade.getEstado());
            pstmt.setString(5, cidade.getRegiaoGeografica());
            pstmt.setDouble(6, cidade.getArea());
            pstmt.setInt(7, (int)(cidade.getPopulacao()));
            pstmt.setDouble(8, cidade.getDomicilios());
            pstmt.setDouble(9, cidade.getPibTotal());
            pstmt.setDouble(10, cidade.getIdh());
            pstmt.setDouble(11, cidade.getRendaMedia());
            pstmt.setDouble(12, cidade.getRendaNominal());
            pstmt.setDouble(13, cidade.getPea());
            pstmt.setDouble(14, cidade.getIdhEducacao());
            pstmt.setDouble(15, cidade.getIdhLongevidade());
            
            int linhasAlteradas = pstmt.executeUpdate();
            if (linhasAlteradas > 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}