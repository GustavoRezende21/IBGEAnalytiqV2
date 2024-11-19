/*
 * Copyright (C) 2024 gusta
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
package Utils;

/**
 *
 * @author gusta
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    // strings de conexão
    String databaseURL = "jdbc:postgresql://localhost/postgres";
    String usuario = "postgres";
    String senha = "admin";
    String driverName = "org.postgresql.Driver";
    
    public void conectar(){
       try {
      Class.forName(driverName).newInstance();
      Connection conn = DriverManager.getConnection(databaseURL, usuario, senha);
      System.out.println("Conexão obtida com sucesso.");
    }
    catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
    catch (Exception e) {
      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
    } 
    
    } 
}