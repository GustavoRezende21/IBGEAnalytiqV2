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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author notebook
 */
public class DAO_Consultar implements DataAcessObject {

    public City consultarPorId(int idInformado) throws SQLException {

        Connection connection = conexao.conectar();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM cidade WHERE cidade.id="+idInformado+";";
        ResultSet resultado = statement.executeQuery(sql);

        System.out.println("EXECUTED QUERY IS");
        System.out.println(sql);
        
        LinkedList<City> cidades = new LinkedList<City>();

        //City[] cidades = new City[300];
        //int i = 0;
        while (resultado.next()){

            String id = ""+resultado.getInt(1);
            String cidade = resultado.getString(2);
            String microregiao = resultado.getString(3);
            String estado = resultado.getString(4);
            String regiaogeografica = resultado.getString(5);
            double areakm = resultado.getDouble(6);
            int populacao = resultado.getInt(7);
            double domicilios = resultado.getDouble(8);
            double pibTotal = resultado.getDouble(9);
            double idh_geral = resultado.getDouble(10);
            double renda_media = resultado.getDouble(11);
            double renda_nominal = resultado.getDouble(12);
            double pea_dia = resultado.getDouble(13);
            double idh_educacao = resultado.getDouble(14);
            double idh_longevidade = resultado.getDouble(15);
            String ultimaalteracao = resultado.getString(16);

            City city = new City(id,cidade,microregiao,estado,regiaogeografica,areakm,populacao,domicilios,pibTotal,idh_geral,renda_media,renda_nominal,pea_dia,idh_educacao,idh_longevidade, ultimaalteracao);

            cidades.add(city);
            //cidades[i] = city;
            //i++;

        }

        connection.close();

        resultado.close();
        statement.close();

        return cidades.get(0);
    }
    
        public City consultarPorNome(String nomeCidade) throws SQLException {

        Connection connection = conexao.conectar();
        Statement statement = connection.createStatement();
        ResultSet resultado = statement.executeQuery("SELECT * FROM cidade WHERE cidade.cidade='"+nomeCidade+"';");

        LinkedList<City> cidades = new LinkedList<City>();

        //City[] cidades = new City[300];
        //int i = 0;
        while (resultado.next()){

            String id = ""+resultado.getInt(1);
            String cidade = resultado.getString(2);
            String microregiao = resultado.getString(3);
            String estado = resultado.getString(4);
            String regiaogeografica = resultado.getString(5);
            double areakm = resultado.getDouble(6);
            int populacao = resultado.getInt(7);
            double domicilios = resultado.getDouble(8);
            double pibTotal = resultado.getDouble(9);
            double idh_geral = resultado.getDouble(10);
            double renda_media = resultado.getDouble(11);
            double renda_nominal = resultado.getDouble(12);
            double pea_dia = resultado.getDouble(13);
            double idh_educacao = resultado.getDouble(14);
            double idh_longevidade = resultado.getDouble(15);
            String ultimaalteracao = resultado.getString(16);

            City city = new City(id,cidade,microregiao,estado,regiaogeografica,areakm,populacao,domicilios,pibTotal,idh_geral,renda_media,renda_nominal,pea_dia,idh_educacao,idh_longevidade, ultimaalteracao);

            cidades.add(city);
            //cidades[i] = city;
            //i++;

        }

        connection.close();

        resultado.close();
        statement.close();

        return cidades.get(0);
    }

}
    
