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
    private JFramePass vistaPass;

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
