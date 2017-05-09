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
public class ControladorAdministrador {
    private JFrameAdministrador vistaAdmin;
    private JFrameAdministrador_addEmp vistaAddEmp;
    private JFrameAdministrador_addHab vistaAddHab;
    
    public ControladorAdministrador(JFrameAdministrador vistaAdmin){
        this.vistaAdmin = vistaAdmin;
    }
    
    public ControladorAdministrador(JFrameAdministrador_addEmp vistaAddEmp){
        this.vistaAddEmp = vistaAddEmp;
    }
    
    public ControladorAdministrador(JFrameAdministrador_addHab vistaAddHab){
        this.vistaAddHab = vistaAddHab;
    }
    
    public void insertarEmpleadoNuevo() throws ClassNotFoundException, SQLException{
        String nombre = vistaAddEmp.getjTextFieldNombre().getText();
        String dni = vistaAddEmp.getjTextFieldDni().getText();
        String usuario = vistaAddEmp.getjTextFieldUsuario().getText();
        String pass = vistaAddEmp.getjTextFieldPass().getText();
        
        if (nombre.equals("") || dni.equals("") || usuario.equals("") || pass.equals("")){
            vistaAddEmp.mostrarError("Debe rellenar todos los campos para registrarse.");
        }
        else{
            ConectarBaseDatos bd= new ConectarBaseDatos();
            ResultSet rs = bd.consultaSelect("INSERT INTO EMPLEADOS (DNI, NOMBRE, USUARIO, PASS) values ('"+dni+"','"+nombre+"','"+usuario+"','"+pass+"');");
            vistaAddEmp.mostrarMensaje("Enhorabuena, se ha registrado con éxito en el sistema.");
        }
    }
    
    public void insertarHabitacionNueva() throws ClassNotFoundException, SQLException{
        String numero = vistaAddHab.getjTextFieldNumero().getText();
        String precio = vistaAddHab.getjTextFieldPrecio().getText();
        String desc = vistaAddHab.getjTextAreaDesc().getText();
        
        if (numero.equals("") || precio.equals("") || desc.equals("")){
            vistaAddHab.mostrarError("Debe rellenar todos los campos para registrarse.");
        }
        else{
            ConectarBaseDatos bd= new ConectarBaseDatos();
            ResultSet rs = bd.consultaSelect("INSERT INTO HABITACIONES (NUMERO, PRECIO, DESCRIPCION) values ('"+numero+"','"+precio+"','"+desc+"');");
            vistaAddHab.mostrarMensaje("Enhorabuena, se ha registrado con éxito en el sistema.");
        }
    }
}
