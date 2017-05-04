/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author manue
 */
public class Repositorio {
    private ArrayList<Habitacion> habitaciones;
    
    public Repositorio(){
        habitaciones = new ArrayList<Habitacion>();
    }
    
    public ArrayList<Habitacion> leerHabitaciones() throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(new File("habitaiones.txt")));
        String linea = br.readLine();
        while(linea != null){
            String[] campos = linea.split(",");
            Habitacion m = new Habitacion(Integer.parseInt(campos[0]), Integer.parseInt(campos[1]), campos[2]);
            habitaciones.add(m);
            linea = br.readLine();
        }
        br.close();
        return habitaciones;
    }
    
}
