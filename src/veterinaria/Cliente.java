/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ronald.gutierrez_ama
 */
public class Cliente {

    public static void main(String[] args) throws IOException {
        Veterinaria vet = new Veterinaria();
        Archivo archivo = new Archivo();
        Scanner leer = new Scanner(System.in);
        boolean salir = false;

        File f = new File("mascotas.txt");
        if (f.exists() && !f.isDirectory()) {
            archivo.cargarArchivo("mascotas.txt", vet);
        }

        while (!salir) {
            System.out.println("1. Agregar mascota");
            System.out.println("2.Ver lista de animales");
            System.out.println("3. Buscar Mascota por código:");
            System.out.println("4. Contador de mascotas tipo ave:");
            System.out.println("5.Eliminar mascotas por código");
            int op;
            op = leer.nextInt();

            switch (op) {
                case 1:
                    vet.anadirMascota(archivo);
                    break;
                case 2:
                    vet.mostrarMascota();
                    break;
                case 3:
                    System.out.println("Digite el código de la mascota que desea buscar");
                    int codigo;
                    codigo = leer.nextInt();
                    System.out.println(vet.buscarCodigo(codigo));
                    break;
                case 4:
                    int tamano = vet.mascotas.size() - 1;
                    if (tamano < 0) {
                        System.out.println("No existen mascotas registradas");
                    }
                    int suma = vet.contadorAves(tamano, 0);
                    System.out.println("Numero de mascotas tipo ave: " + suma);
                    break;
                case 5:
                    System.out.println("Digite el código de la mascota que desea eliminar");
                    int codigoABorrar;
                    codigoABorrar = leer.nextInt();
                    vet.borrarMascota(codigoABorrar, archivo);
                    break;
                case 6:
                    salir = true;
                    break;

                default:
                    System.out.println("opción incorrecta");
            }
        }
    }

}
