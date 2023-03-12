/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package veterinaria;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ronald.gutierrez_ama
 */
public class Veterinaria {

    List<Animal> mascotas;

    public Veterinaria() {
        mascotas = new ArrayList<>();
    }

    public void anadirMascota(Archivo archivo) throws IOException {
        Animal animal = new Animal();
        int tipo, codigo;
        Scanner leer = new Scanner(System.in);
        System.out.println("Nombre mascota:");
        animal.setNombreMascota(leer.nextLine());
        
        System.out.println("Tipo:");
        System.out.println("1. Canino");
        System.out.println("2. Felino");
        System.out.println("3. Ave");
        tipo = leer.nextInt();

        while (tipo > 3) {
            System.out.println("Tipo de animal no valido");
            System.out.println("Seleccione un tipo de animal valido:");
            System.out.println("1. Canino");
            System.out.println("2. Felino");
            System.out.println("3. Ave");
            tipo=leer.nextInt();
        }
        animal.setTipo(tipo);
        
        
        System.out.println("Código de la mascota:");
        codigo = leer.nextInt();
        
        while(codigo<0){
            System.out.println("El codigo no puede ser un numero negativo");
            System.out.println("Digite un valor de codigo valido");
            codigo = leer.nextInt();
        }
        animal.setCodigo(codigo);
        this.mascotas.add(animal);
        String cadena = animal.getCodigo()  + "," + animal.getNombreMascota() +","+ animal.getTipo();
        archivo.guardarEnArchivo("mascotas.txt", cadena, true);
        System.out.println("Mascota registrada exitosamente");


    }

    public void mostrarMascota() {
        int longitud = mascotas.size() - 1;
        if (longitud < 0) {
            System.out.println("No existen mascotas registradas");
        } else {
            mostrarMascota(mascotas.size() - 1);
        }

    }

    public void mostrarMascota(int tamano) {
        if (tamano == 0) {
            System.out.println(mascotas.get(0).getCodigo() + ", " + mascotas.get(0).getNombreMascota());
        } else {
            System.out.println(mascotas.get(tamano).getCodigo() + ", " + mascotas.get(tamano).getNombreMascota());
            mostrarMascota(tamano-1);
        }
    }

    public Animal buscarCodigo(int codigo) {
        Animal mascota = null;
        for(int i = 0; i<mascotas.size(); i++){
            int codigoAnimal = mascotas.get(i).getCodigo();
            if(codigo == codigoAnimal){
                mascota = mascotas.get(i);
                break;
            }else{
                mascota = null;
            }
        }
        return mascota;
    }

    public int contadorAves() {
        int tamano = mascotas.size() - 1;
        if (tamano < 0) {
            System.out.println("No existen mascotas registradas");
        }
        int cantidad = contadorAves(tamano, 0);
        return cantidad;
    }

    public int contadorAves(int tamano, int suma) {
        if (tamano >= 0) {
            if (mascotas.get(tamano).getTipo() == 3) {
                suma = suma+1 ;
                return contadorAves(tamano-1, suma);
            } else {
               return contadorAves(tamano-1, suma);
            }
        } else return suma;
     }

    public void borrarMascota(int codigo, Archivo archivo) throws IOException {
        int posicion = mascotas.indexOf(buscarCodigo(codigo));
        System.out.println("posicion " + posicion);
        mascotas.remove(posicion);        
        File f = new File("mascotas.txt");
        f.delete();
        for(Animal animal: mascotas){
            String cadena = animal.getCodigo() + "," + animal.getNombreMascota() + "," + animal.getTipo();
            archivo.guardarEnArchivo("mascotas.txt", cadena, true);
        }
    }

}
