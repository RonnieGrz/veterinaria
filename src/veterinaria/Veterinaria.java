/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package veterinaria;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ronald.gutierrez_ama
 */
public class Veterinaria {

       ArrayList mascotas;

    public Veterinaria() {
        mascotas=new ArrayList<Animal>();
    }

 
       public void anadirMascota(){
           Animal animal= new Animal();
           Scanner leer= new Scanner(System.in);
           System.out.println("Nombre mascota:");
           animal.setNombreMascota(leer.nextLine());
           System.out.println("Tipo:");
           animal.setTipo(leer.nextLine());
           System.out.println("Código de la mascota:");
           animal.setCodigo(leer.nextInt());
           this.mascotas.add(animal);
       }
       
       public void mostrarMascota(){
           mostrarMascota(mascotas, mascotas.size());
           
       }
       public void mostrarMascota(ArrayList mascotas,int tamano){
           if(tamano!=0){
               System.out.println(mascotas.get(tamano));
               mostrarMascota(mascotas, tamano--);
           }
       }
       
       public void buscarCodigo(int codigo){
         //  mascotas.get(codigo).get;
       }
    
}