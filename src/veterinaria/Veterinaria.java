/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package veterinaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author ronald.gutierrez_ama
 */
public class Veterinaria {

       List<Animal> mascotas = new ArrayList<>();

    public Veterinaria() {
        //mascotas = new ArrayList<Animal>();
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
       public void mostrarMascota(List mascotas, int tamano){
           if(tamano!=0){
               System.out.println(mascotas.get(tamano));
               mostrarMascota(mascotas, tamano--);
           }
       }
       
       public Animal buscarCodigo(int codigo){
           return buscarCodigo(codigo, mascotas.size(), false);
       }
       
       public Animal buscarCodigo(int codigo, int tamano, boolean existe){
           Animal mascota = null;
           if(tamano!=0 && !existe){
               if(codigo == mascotas.get(tamano).getCodigo()){
                   existe = true;
                   mascota = mascotas.get(tamano);
               }else{
                   buscarCodigo(codigo, tamano--, false);
               }
           }
           return mascota;
       }
       
       public int contadorAves(){
           int tamano = mascotas.size();
           return contadorAves(tamano, 0);
       }
       
       public int contadorAves(int tamano, int suma){
           if(tamano!=0){
               if("Ave".equals(mascotas.get(tamano).getTipo())){
                   suma++;
               }else{
                   contadorAves(tamano--, suma);
               }
           }
           return suma;
       }
       
       public void borrarMascota(int codigo){
           mascotas.remove(mascotas.indexOf(buscarCodigo(codigo)));
       }
    
}