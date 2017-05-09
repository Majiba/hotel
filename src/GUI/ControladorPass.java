/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.*;
import modelo.ConectarBaseDatos;

/**
 *
 * @author Manuel Jiménez Bascón
 */
public class ControladorPass {
    
    private JFrameCliente vistaCliente;
    private JFramePrincipal vistaPrincipal;
    private JFrameAdministrador vistaAdmin;
    private JFrameMenu vistaCocinero;
    private JFramePass vistaPass;
    private JFrameLimpiador vistaLimpiador;
    private JFrameRecepcionista vistaRecepcion;
    private GUI.ControladorPrincipal controladorPrincipal;
    private modelo.ConectarBaseDatos conectar;
    
    public ControladorPass(JFramePass vistaPass){
        this.vistaPass = vistaPass;
    }
    
    public void solicitarEmpleado(){
        new JFrameEmpleado().setVisible(true);
        vistaPass.dispose();
    }
    
    public boolean comprobarPass() throws SQLException, ClassNotFoundException{
        String usuario = vistaPass.getjTextFieldUsuario().getText();
        String pass = vistaPass.getjTextFieldPass().getText();
        
        if(usuario==null||pass==null)vistaPass.mostrarError("Los campos usuario o contraseña no pueden ser nulos");
        
        Connection c = ConectarBaseDatos.conexionBd();
        
        Statement stmt = c.createStatement();
        
        ResultSet rs = stmt.executeQuery("SELECT PASS FROM EMPLEADOS WHERE USUARIO='"+usuario+"';");
        rs.next();
        if(rs.getString(1).equals(pass)){
            return true;
        }else{
            return false;
        }
        
    }
}
