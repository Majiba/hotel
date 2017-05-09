package modelo;

/**
 *
 * @author Manuel Jiménez Bascón
 */
public class Empleado {
    
    private String nombre;
    private String dni;
    private String usuario;
    private String pass;

    public Empleado(String nombre, String dni, String usuario, String pass) {
        this.nombre = nombre;
        this.dni = dni;
        this.usuario = usuario;
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
