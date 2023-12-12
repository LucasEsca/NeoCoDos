/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package class_13;

/**
 *
 * @author Usuario
 */
public abstract class Persona {
    
    private String nombre;

    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    //Métodos abstractos
    public abstract void saludar();
    
    public abstract void trabajar();
    
    //Otros métodos con implementación concreta
    public void presentarse(){
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }
}
