/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;

/**
 *
 * @author Manuel Jiménez Bascón
 */
public class ConectarBaseDatos {
    public static Connection conexionBd() throws ClassNotFoundException{
        Class.forName("org.mariadb.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/hotel";
        String user="root";
        String pass="";
        Connection c;
        try{
            c=DriverManager.getConnection(url, user, pass);
            return c;
        }catch(SQLException e){
            System.out.println("No se ha establecido conexión");
            e.printStackTrace();
        }
        return null;
    }
}
