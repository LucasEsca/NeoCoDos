/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tareas.Modulo2;

/**
 *
 * @author Usuario
 */
public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private boolean alquilado;

    public Libro(String titulo, String autor, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.alquilado = false;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }

    @Override
public String toString() {
    String estadoAlquiler = alquilado ? "Alquilado" : "Disponible";
    return "Libro{" +
            "titulo='" + titulo + '\'' +
            ", autor='" + autor + '\'' +
            ", genero='" + genero + '\'' +
            ", estado='" + estadoAlquiler + '\'' +
            '}';
}
}
