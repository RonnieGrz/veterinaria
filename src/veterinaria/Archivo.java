/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria;

import java.io.*;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ronald.gutierrez_ama
 */
public class Archivo {

    String nombreArchivo;
    
    public Archivo() {
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
       
    
    
    public void guardarEnArchivo(String archivo, String cadena, boolean tieneSiguiente) throws IOException{
        
        File archivo1 = new File(archivo);
        PrintWriter pw = new PrintWriter(new FileWriter(archivo1, true));
        pw.println(cadena);
        pw.close(); 
    }
    
    
    public static void cargarArchivo(String nombreArchivo, Veterinaria vet) throws FileNotFoundException{
        
        File archivo = new File(nombreArchivo);
        Scanner cargarArchivo = new Scanner(archivo);
        vet.mascotas.clear();
        
        while(cargarArchivo.hasNextLine()){
            String linea =  cargarArchivo.nextLine();
            String[] datos = linea.split(",");
            Animal mascota = new Animal();
            
            mascota.setCodigo(Integer.parseInt(datos[0]));
            mascota.setNombreMascota(datos[1]);
            mascota.setTipo(Integer.parseInt(datos[2]));
            vet.mascotas.add(mascota);
        }
        
        cargarArchivo.close();
    }
    
}