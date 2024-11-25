package Dao;

import Model.City;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;
import Model.City;
import Utils.Ordenacoes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DAO_Deletar implements DataAcessObject{

    public boolean deletarId(int id) throws SQLException{

        Connection connection = conexao.conectar();
        Statement statement = connection.createStatement();
        ResultSet resultado = statement.executeQuery("DELETE FROM "+"cidades WHERE "+"cidade.id ="+id);

        System.out.printf(resultado.toString());

        return true;

    }

}
