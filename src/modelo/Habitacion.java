package modelo;

/**
 *
 * @author Manuel Jiménez Bascón
 */
public class Habitacion {
    
    private int numero;
    private double precio;
    private String descripcion;
    private String disponible;
    private String sucia;

    public Habitacion(int numero, double precio, String descripcion, String disponible, String sucia) {
        this.numero = numero;
        this.precio = precio;
        this.descripcion = descripcion;
        this.disponible = disponible;
        this.sucia = sucia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public String getSucia() {
        return sucia;
    }

    public void setSucia(String sucia) {
        this.sucia = sucia;
    }
    
    
}
