/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package class_13;

/**
 *
 * @author Usuario
 */
public class Estudiantes extends Persona {
    
    private final String curso;
    
    public Estudiantes(String nombre, int edad, String curso){
        super(nombre, edad);
        this.curso = curso;
    }

    @Override
    public void saludar() {
       System.out.println("Hola soy " + getNombre() + " y  estudio en el curso de " + curso);
    }

    @Override
    public void trabajar() {
        System.out.println("Estoy estudiante para el viaje a Punta Cana");
    }
}
