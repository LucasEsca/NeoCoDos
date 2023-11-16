/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tareas.Modulo1;

/**
 *
 * @author Usuario
 */
public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private String fechaNacimiento;

    public Persona(String nombre, String apellido, String dni, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Nombre y Apellido: " + nombre +
                " " + apellido +
                ", DNI: " + dni +
                ", Fecha de Nacimiento: " + fechaNacimiento;
    }
    public String getDni() {
        return dni;
    }
}

