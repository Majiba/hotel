package modelo;

/**
 *
 * @author Manuel Jiménez Bascón
 */
public class Habitacion {
    
    private int numero;
    private double precio;
    private String descripcion;
    private int disponible;
    private int sucia;

    public Habitacion(int numero, double precio, String descripcion, int disponible, int sucia) {
        this.numero = numero;
        this.precio = precio;
        this.descripcion = descripcion;
        this.disponible = disponible;
        this.sucia = sucia;
    }

    public Habitacion(int numero, double precio, String descripcion) {
        this.numero = numero;
        this.precio = precio;
        this.descripcion = descripcion;
        this.disponible = 1;
        this.sucia = 0;
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

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public int getSucia() {
        return sucia;
    }

    public void setSucia(int sucia) {
        this.sucia = sucia;
    }
    
    
}
