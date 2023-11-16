/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tareas.Modulo1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class RegistrodePersonas {
    static ArrayList<Persona> personas = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, getMenu()));

            switch (opcion) {
                case 1:
                    registrarPersona();
                    break;
                case 2:
                    listarPersonas();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "App Finalizada");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Escriba una opcion valida.");
            }
        } while (opcion != 3);
    }

    static String getMenu() {
        return "--- Menú ---\n" +
                "1. Registre una Persona\n" +
                "2. Lista de Personas\n" +
                "3. Salir\n" +
                "Ingresar opcion:";
    }

    static void registrarPersona() {
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String apellido = JOptionPane.showInputDialog("Apellido:");
        String dni = JOptionPane.showInputDialog("DNI (8 dígitos):");

        if (!validarDNIUnico(dni)) {
            JOptionPane.showMessageDialog(null, "Ya existe una persona con el mismo DNI. Inténtalo de nuevo.");
            return;
        }

        String fechaNacimiento = JOptionPane.showInputDialog("Fecha de Nacimiento (dd/mm/yyyy):");

        if (validarDatos(nombre, apellido, dni, fechaNacimiento)) {
            Persona nuevaPersona = new Persona(nombre, apellido, dni, fechaNacimiento);
            personas.add(nuevaPersona);
            JOptionPane.showMessageDialog(null, "Persona registrada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Dato inválidos. Inténtalo de nuevo.");
        }
    }

    static void listarPersonas() {
        if (personas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay personas registradas.");
        } else {
            StringBuilder mensaje = new StringBuilder("--- Listado de Personas ---\n");
            for (Persona persona : personas) {
                mensaje.append(persona).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString());
        }
    }

    static boolean validarDatos(String nombre, String apellido, String dni, String fechaNacimiento) {
        if (nombre.isEmpty() || apellido.isEmpty()) {
            return false;
        }

        
        if (!validarDNIUnico(dni)) {
            return false;
        }

        
        if (!fechaNacimiento.matches("\\d{2}/\\d{2}/\\d{4}")) {
            return false;
        }

        
        String[] partesFecha = fechaNacimiento.split("/");
        int dia = Integer.parseInt(partesFecha[0]);
        int mes = Integer.parseInt(partesFecha[1]);
        int anio = Integer.parseInt(partesFecha[2]);

        if (dia <= 0 || dia >= 32 || mes <= 0 || mes >= 13) {
            return false;
        }

        return true;
    }

    static boolean validarDNIUnico(String dni) {
        for (Persona persona : personas) {
            if (persona.getDni().equals(dni)) {
                return false;
            }
        }
        return true;
    }
    
}

