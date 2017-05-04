/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Manuel
 */
public class Habitacion implements Serializable{
    private int numHabitacion;
    private int capacidadMax;
    private String Tipo;

    public Habitacion(int numHabitacion, int capacidaMax, String Tipo) {
        this.numHabitacion = numHabitacion;
        this.capacidadMax = capacidaMax;
        this.Tipo = Tipo;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public int getCapacidaMax() {
        return capacidadMax;
    }

    public void setCapacidaMax(int capacidaMax) {
        this.capacidadMax = capacidaMax;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
}