/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.*;
import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author manue
 */
public class ControladorPrincipal {
    
    private JFrameCliente vistaCliente;
    private JFramePrincipal vistaPrincipal;
    private JFrameAdministrador vistaAdmin;
    private JFrameMenu vistaCocinero;
    private JFramePass vistaPass;
    private JFrameLimpiador vistaLimpiador;
    private JFrameRecepcionista vistaRecepcion;
    
    public ControladorPrincipal(JFramePrincipal vistaPrincipal){
        this.vistaPrincipal = vistaPrincipal;
    }
 
    public void solicitarPass(){
        new JFramePass().setVisible(true);
        vistaPrincipal.dispose();
    }
    
    public void solicitarUsuario(){
        new JFrameLoginCliente().setVisible(true);
        vistaPrincipal.dispose();
    }
    
    public static ArrayList<Habitacion> listarHabitaciones() throws ClassNotFoundException{
        
        ArrayList<Habitacion> hab = new ArrayList<>();
        
        
        try{
        Connection c = ConectarBaseDatos.conexionBd();
        
        Statement stmt = c.createStatement();
        
        String consulta = "SELECT numero, precio, descripcion, disponible, sucia FROM HABITACION;";
        
        ResultSet rs = stmt.executeQuery(consulta);
        while(rs.next()){
            hab.add(new Habitacion(Integer.parseInt(rs.getString(1)), Double.parseDouble(rs.getString(2)), rs.getString(3), Integer.parseInt(rs.getString(4)), Integer.parseInt(rs.getString(5))));
        }
        
        return hab;
        }catch(SQLException e){
            System.out.println("Se ha producido un error en la conexión con la base de datos");
        }
        
        return null;
    }
    
    
}
