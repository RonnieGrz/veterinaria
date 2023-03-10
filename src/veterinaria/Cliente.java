/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria;

import java.util.Scanner;

/**
 *
 * @author ronald.gutierrez_ama
 */
public class Cliente {
    
    public static void main(String[] args) {
        Veterinaria vet = new Veterinaria();
        Scanner leer= new Scanner(System.in);
        System.out.println("1. Agregar mascota");
        System.out.println("2.Ver lista de animales");
        System.out.println("3. Buscar Mascota por código:");
        System.out.println("4. Contador de mascotas tipo ave:");
        System.out.println("5.Eliminar mascotas por código");
        int op;
        op=leer.nextInt();
        
        switch(op){
            case 1:
                vet.anadirMascota();
                break;
                
            case 2:
                vet.mostrarMascota();
                break;
            case 3:
                System.out.println("Digite el código de la mascota que desea buscar");
                int codigo;
                codigo=leer.nextInt();
                vet.buscarCodigo(codigo);
                break;
            case 4:
                vet.contadorAves();
                break;
            case 5:
                System.out.println("Digite el código de la mascota que desea eliminar");
                int borrar;
                borrar=leer.nextInt();
                vet.borrarMascota(borrar);
                break;
        }
    }
    
}

