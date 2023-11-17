/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tareas.Modulo2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Usuario
 */
public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        inicializarLibrosPorDefecto();
    }
    
    private void inicializarLibrosPorDefecto() {
        agregarLibro(new Libro("El señor de los anillos", "J.R.R. Tolkien", "Fantasía"));
        agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", "Realismo mágico"));
        agregarLibro(new Libro("1984", "George Orwell", "Distopía"));
        agregarLibro(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "Novela"));
        agregarLibro(new Libro("Crimen y castigo", "Fiodor Dostoievski", "Novela psicológica"));
        // Agrega más libros por defecto si es necesario
    }

    // Métodos getter para libros y usuarios

    public List<Libro> getLibros() {
        return libros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    // Métodos para operaciones en la biblioteca

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public boolean eliminarLibro(String titulo) {
        return libros.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
    }

    public Libro buscarLibro(String titulo) {
        return libros.stream()
                .filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public boolean alquilarLibro(Usuario usuario, String titulo) {
        Libro libro = buscarLibro(titulo);

        if (libro != null && !libro.isAlquilado()) {
            libro.setAlquilado(true);
            return true;
        }

        return false;
    }

    public boolean devolverLibro(Usuario usuario, String titulo) {
        Libro libro = buscarLibro(titulo);

        if (libro != null && libro.isAlquilado()) {
            libro.setAlquilado(false);
            return true;
        }

        return false;
    }

    public Usuario autenticarUsuario(String mail, String contraseña) {
        return usuarios.stream()
                .filter(usuario -> usuario.getMail().equalsIgnoreCase(mail) && usuario.getContraseña().equals(contraseña))
                .findFirst()
                .orElse(null);
    }

    public boolean existeUsuarioConMail(String mail) {
        return usuarios.stream().anyMatch(usuario -> usuario.getMail().equalsIgnoreCase(mail));
    }

    public List<Libro> buscarLibrosPorPalabraClave(String palabraClave) {
    String keyword = palabraClave.toLowerCase();

    return libros.stream()
            .filter(libro -> 
                    libro.getTitulo().toLowerCase().contains(keyword) ||
                    libro.getAutor().toLowerCase().contains(keyword) ||
                    libro.getGenero().toLowerCase().contains(keyword))
            .collect(Collectors.toList());
}

    // Otros métodos relacionados con la gestión de usuarios

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    
}
