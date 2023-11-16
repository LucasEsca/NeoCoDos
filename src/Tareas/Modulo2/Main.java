/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tareas.Modulo2;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        
        while (true) {
            int opcion = mostrarMenuPrincipal();

            switch (opcion) {
                case 1:
                    registrarUsuario(biblioteca);
                    break;
                case 2:
                    Usuario usuarioAutenticado = autenticarUsuario(biblioteca);
                    if (usuarioAutenticado != null) {
                        menuBiblioteca(biblioteca, usuarioAutenticado);
                    }
                    break;
                case 3:
                    mostrarLibros(biblioteca);
                    break;
                case 4:
                    System.exit(0); // Salir del programa
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static int mostrarMenuPrincipal() {
        String[] opciones = {"Registrarse", "Iniciar Sesión", "Ver Libros", "Salir"};
        return JOptionPane.showOptionDialog(
                null,
                "Bienvenido a la Biblioteca\nSeleccione una opción:",
                "Biblioteca App",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        ) + 1;
    }
    
       private static void registrarUsuario(Biblioteca biblioteca) {
    String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
    String apellido = JOptionPane.showInputDialog("Ingrese su apellido:");
    String mail = JOptionPane.showInputDialog("Ingrese su correo electrónico:");

    // Verificar si el correo electrónico ya existe
    while (biblioteca.existeUsuarioConMail(mail)) {
        JOptionPane.showMessageDialog(null, "Ya existe un usuario registrado con ese correo electrónico. Inténtelo de nuevo.");
        mail = JOptionPane.showInputDialog("Ingrese su correo electrónico:");
    }

    String contraseña = JOptionPane.showInputDialog("Ingrese su contraseña:");

    // Crear y registrar el usuario en la biblioteca
    Usuario nuevoUsuario = new Usuario(nombre, apellido, mail, contraseña);
    biblioteca.registrarUsuario(nuevoUsuario);

    JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente. Ahora puede iniciar sesión.");
}

    private static Usuario autenticarUsuario(Biblioteca biblioteca) {
    String mail = JOptionPane.showInputDialog("Ingrese su correo electrónico:");
    String contraseña = JOptionPane.showInputDialog("Ingrese su contraseña:");

    // Buscar al usuario en la biblioteca
    Usuario usuarioAutenticado = biblioteca.autenticarUsuario(mail, contraseña);

    if (usuarioAutenticado != null) {
        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. ¡Bienvenido, " + usuarioAutenticado.getNombre() + "!");
    } else {
        JOptionPane.showMessageDialog(null, "Error de autenticación. Verifique sus credenciales e inténtelo de nuevo.");
    }

    return usuarioAutenticado;
}


    private static void menuBiblioteca(Biblioteca biblioteca, Usuario usuario) {
    while (true) {
        int opcion = mostrarMenuBiblioteca();

        switch (opcion) {
            case 1:
                gestionarLibros(biblioteca, usuario);
                break;
            case 2:
                buscarLibros(biblioteca);
                break;
            case 3:
                alquilarLibro(biblioteca, usuario);
                break;
            case 4:
                devolverLibro(biblioteca, usuario);
                break;
            case 5:
                generarInforme(usuario);
                break;
            case 6:
                return; // Volver al menú principal
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
        }
    }
}

private static int mostrarMenuBiblioteca() {
    String[] opciones = {"Gestionar Libros", "Buscar Libros", "Alquilar Libro", "Devolver Libro", "Generar Informe", "Salir a Menú Principal"};
    return JOptionPane.showOptionDialog(
            null,
            "Menú de la Biblioteca\nSeleccione una opción:",
            "Biblioteca App",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            opciones,
            opciones[0]
    ) + 1;
}

private static void gestionarLibros(Biblioteca biblioteca, Usuario usuario) {
    while (true) {
        int opcion = mostrarMenuGestionLibros();

        switch (opcion) {
            case 1:
                agregarLibro(biblioteca);
                break;
            case 2:
                eliminarLibro(biblioteca);
                break;
            case 3:
                editarLibro(biblioteca);
                break;
            case 4:
                return; // Volver al menú de la biblioteca
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
        }
    }
}

private static int mostrarMenuGestionLibros() {
    String[] opciones = {"Agregar Libro", "Eliminar Libro", "Editar Libro", "Volver a Menú de la Biblioteca"};
    return JOptionPane.showOptionDialog(
            null,
            "Gestión de Libros\nSeleccione una opción:",
            "Biblioteca App",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            opciones,
            opciones[0]
    ) + 1;
}

private static void agregarLibro(Biblioteca biblioteca) {
    String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
    String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
    String genero = JOptionPane.showInputDialog("Ingrese el género del libro:");

    Libro nuevoLibro = new Libro(titulo, autor, genero);
    biblioteca.agregarLibro(nuevoLibro);

    JOptionPane.showMessageDialog(null, "Libro agregado exitosamente: " + nuevoLibro.getTitulo());
}

private static void eliminarLibro(Biblioteca biblioteca) {
    String titulo = JOptionPane.showInputDialog("Ingrese el título del libro a eliminar:");
    
    if (biblioteca.eliminarLibro(titulo)) {
        JOptionPane.showMessageDialog(null, "Libro eliminado exitosamente: " + titulo);
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró un libro con el título proporcionado.");
    }
}

private static void editarLibro(Biblioteca biblioteca) {
    String titulo = JOptionPane.showInputDialog("Ingrese el título del libro a editar:");
    Libro libroExistente = biblioteca.buscarLibro(titulo);

    if (libroExistente != null) {
        String nuevoTitulo = JOptionPane.showInputDialog("Ingrese el nuevo título del libro:");
        String nuevoAutor = JOptionPane.showInputDialog("Ingrese el nuevo autor del libro:");
        String nuevoGenero = JOptionPane.showInputDialog("Ingrese el nuevo género del libro:");

        libroExistente.setTitulo(nuevoTitulo);
        libroExistente.setAutor(nuevoAutor);
        libroExistente.setGenero(nuevoGenero);

        JOptionPane.showMessageDialog(null, "Libro editado exitosamente. Nuevo título: " + nuevoTitulo);
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró un libro con el título proporcionado.");
    }
}



private static void buscarLibros(Biblioteca biblioteca) {
    String opcion = JOptionPane.showInputDialog("Ingrese la opción de búsqueda:\n1. Título\n2. Autor\n3. Género");
    String criterio = JOptionPane.showInputDialog("Ingrese el criterio de búsqueda:");

    switch (opcion) {
        case "1":
            List<Libro> librosPorTitulo = biblioteca.buscarLibrosPorTitulo(criterio);
            mostrarResultadosBusqueda(librosPorTitulo, "Libros encontrados por título:");
            break;
        case "2":
            List<Libro> librosPorAutor = biblioteca.buscarLibrosPorAutor(criterio);
            mostrarResultadosBusqueda(librosPorAutor, "Libros encontrados por autor:");
            break;
        case "3":
            List<Libro> librosPorGenero = biblioteca.buscarLibrosPorGenero(criterio);
            mostrarResultadosBusqueda(librosPorGenero, "Libros encontrados por género:");
            break;
        default:
            JOptionPane.showMessageDialog(null, "Opción de búsqueda no válida.");
    }
}

private static void alquilarLibro(Biblioteca biblioteca, Usuario usuario) {
    String titulo = JOptionPane.showInputDialog("Ingrese el título del libro a alquilar:");
    
    if (biblioteca.alquilarLibro(usuario, titulo)) {
        JOptionPane.showMessageDialog(null, "Libro alquilado exitosamente: " + titulo);
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró un libro disponible con el título proporcionado.");
    }
}

private static void devolverLibro(Biblioteca biblioteca, Usuario usuario) {
    String titulo = JOptionPane.showInputDialog("Ingrese el título del libro a devolver:");

    if (biblioteca.devolverLibro(usuario, titulo)) {
        JOptionPane.showMessageDialog(null, "Libro devuelto exitosamente: " + titulo);
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró un libro alquilado con el título proporcionado.");
    }
}

private static void generarInforme(Usuario usuario) {
    String informe = JOptionPane.showInputDialog("Escriba su informe o estadísticas sobre la biblioteca:");
    // Puedes guardar o procesar el informe según tus necesidades
    JOptionPane.showMessageDialog(null, "Informe enviado exitosamente. ¡Gracias por tu feedback!");
}

private static void mostrarLibros(Biblioteca biblioteca) {
    List<Libro> todosLosLibros = biblioteca.getLibros();
    mostrarResultadosBusqueda(todosLosLibros, "Lista de todos los libros en la biblioteca:");
}

private static void mostrarResultadosBusqueda(List<Libro> resultados, String mensaje) {
    if (resultados.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No se encontraron resultados.");
    } else {
        StringBuilder mensajeResultados = new StringBuilder(mensaje + "\n");
        for (Libro libro : resultados) {
            mensajeResultados.append("- ").append(libro.getTitulo()).append(" (").append(libro.getAutor()).append(")\n");
        }
        JOptionPane.showMessageDialog(null, mensajeResultados.toString());
    }
}


}
