/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria;

/**
 *
 * @author ronald.gutierrez_ama
 */
public class Animal {
    int codigo;
    int tipo;
    String nombreMascota;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        if(tipo <= 3){
        this.tipo = tipo;    
        }else{
            throw new IllegalArgumentException("No existe un tipo de animal con ese valor");
        }
        
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public Animal(int codigo, int tipo, String nombreMascota) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombreMascota = nombreMascota;
    }
    public Animal() {
        
    }
    
    
    
}
