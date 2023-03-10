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

    public void anadirMascota() {
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

    public String buscarCodigo(int codigo) {
        return buscarCodigo(codigo, mascotas.size() - 1, false);
    }

    public String buscarCodigo(int codigo, int tamano, boolean existe) {
        String mascota = null;
        Animal animal;
        if (tamano == 0) {
            if (codigo == mascotas.get(0).getCodigo()) {
                existe = true;
                animal = mascotas.get(0);
                mascota = "Mascota: \n" + animal.getCodigo() + ", "+animal.getNombreMascota() + ", " + animal.getTipo() ;
            } else {
                System.out.println("Codigo no registrado");
            }
        }
        if (tamano != 0 && !existe) {
            if (codigo == mascotas.get(tamano).getCodigo()) {
                existe = true;
                animal = mascotas.get(tamano);
                mascota = "Mascota: \n" + animal.getCodigo() + ", "+animal.getNombreMascota() + ", " + animal.getTipo() ;
            } else {
                buscarCodigo(codigo, tamano--, false);
            }
        }
        return mascota;
    }

    public int contadorAves() {
        int tamano = mascotas.size() - 1;
        if (tamano < 0) {
            System.out.println("No existen mascotas registradas");
        }
        return contadorAves(tamano, 0);
    }

    public int contadorAves(int tamano, int suma) {
        if (tamano != 0) {
            if (mascotas.get(tamano).getTipo() == 3) {
                suma++;
            } else {
                contadorAves(tamano--, suma);
            }
        }
        return suma;
    }

    public void borrarMascota(int codigo) {
        mascotas.remove(mascotas.indexOf(buscarCodigo(codigo)));
    }

}
