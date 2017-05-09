/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ConectarBaseDatos;
import modelo.Habitacion;

/**
 *
 * @author Manuel Jiménez Bascón
 */


public class ControladorCliente {
    private JFrameLoginCliente vistaLogin;
    private modelo.ConectarBaseDatos baseDatos;
    private JFrameCliente_reservar vistaReservar;
    private JFrameCliente vistaCliente;
    private JFrameMenu vistaMenu;
    
    public ControladorCliente(JFrameCliente_reservar vistaReservar){
        this.vistaReservar = vistaReservar;
    }
    
    public ControladorCliente(JFrameMenu vistaMenu){
        this.vistaMenu = vistaMenu;
    }
    
    public ControladorCliente(JFrameCliente vistaCliente){
        this.vistaCliente = vistaCliente;
    }
    
    public ControladorCliente(JFrameLoginCliente vistaLogin){
        this.vistaLogin = vistaLogin;
    }
    public void listarHabitacionesDisponibles() throws ClassNotFoundException, SQLException{
        
        DefaultTableModel dfm = new DefaultTableModel();
        dfm.addColumn("Número");
        dfm.addColumn("Precio");
        dfm.addColumn("Descripción");
        
        ConectarBaseDatos bd= new ConectarBaseDatos();
        ResultSet rs = bd.consultaSelect("SELECT * FROM HABITACIONES WHERE DISPONIBLE=1;");
        while(rs.next()){
            String[] fila = {rs.getString("numero"), rs.getString("precio"), rs.getString("descripcion")};
            dfm.addRow(fila);
        }
        vistaReservar.getjTableDisponibles().setModel(dfm);
    }
    
    public void insertarClienteNuevo() throws ClassNotFoundException, SQLException{
        String nombre = vistaLogin.getjTextFieldNombreCliente().getText();
        String dni = vistaLogin.getjTextFieldDni().getText();
        if (nombre.equals("") || dni.equals("")){
            vistaLogin.mostrarError("Debe rellenar ambos campos para registrarse.");
        }
        else{
            ConectarBaseDatos bd= new ConectarBaseDatos();
            ResultSet rs = bd.consultaSelect("INSERT INTO CLIENTES (NOMBRE, DNI) values ('"+nombre+"','"+dni+"');");
            vistaLogin.mostrarMensaje("Enhorabuena, se ha registrado con éxito en el sistema.");
        }
    }
    
    public boolean comprobarCliente() throws ClassNotFoundException, SQLException{
        String nombre = vistaLogin.getjTextFieldNombreCliente().getText();
        String dni = vistaLogin.getjTextFieldDni().getText();
        
        Connection c = ConectarBaseDatos.conexionBd();
        
        Statement stmt = c.createStatement();
        
        ResultSet rs = stmt.executeQuery("SELECT NOMBRE FROM CLIENTES WHERE DNI='"+dni+"';");
        rs.next();
        if(rs.getString(1).equals(nombre)){
            return true;
        }else{
            return false;
        }
    }
    
    public void accesoMenuClientes(){
        vistaCliente.dispose();
        new JFrameMenu().setVisible(true);
        vistaMenu.setjButtonEditarMenuVisible();
        
    }
}
