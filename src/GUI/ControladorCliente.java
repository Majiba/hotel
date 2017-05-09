/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.*;
import java.util.ArrayList;
import modelo.Habitacion;

/**
 *
 * @author Manuel Jiménez Bascón
 */
public class ControladorCliente {
    public static ArrayList<Habitacion> listarHabitacionesDisponibles(){
        
        ArrayList<Habitacion> hab = new ArrayList<>();
        
        
        try{
        try{
        Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException c){
            System.out.println("No se encuentra el conector de la Base de Datos");
        }
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
        
        Statement stmt = conn.createStatement();
        
        String consulta = "SELECT * FROM HABITACION;";
        
        ResultSet rs = stmt.executeQuery(consulta);
        while(rs.next()){
            hab.add(new Habitacion(Integer.parseInt(rs.getString(1)), Double.parseDouble(rs.getString(2)), rs.getString(3), rs.getString(4), rs.getString(5)));
        }
        
        return hab;
        }catch(SQLException e){
            System.out.println("Se ha producido un error en la conexión con la base de datos");
        }
        
        return null;
    }
}
