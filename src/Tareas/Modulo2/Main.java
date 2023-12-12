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
                    System.exit(0); 
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

    if (nombre == null) {
        return;
    }

    String apellido = JOptionPane.showInputDialog("Ingrese su apellido:");
    if (apellido == null) {
        return;
    }

    String mail = JOptionPane.showInputDialog("Ingrese su correo electrónico:");
    if (mail == null) {
        return;
    }

    while (biblioteca.existeUsuarioConMail(mail)) {
        JOptionPane.showMessageDialog(null, "Ya existe un usuario registrado con ese correo electrónico. Inténtelo de nuevo.");

        mail = JOptionPane.showInputDialog("Ingrese su correo electrónico:");
        if (mail == null) {
            return;
        }
    }

    String contraseña = JOptionPane.showInputDialog("Ingrese su contraseña:");
    if (contraseña == null) {
        return;
    }

 
    if (nombre.isEmpty() || apellido.isEmpty() || mail.isEmpty() || contraseña.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        return;
    }


    Usuario nuevoUsuario = new Usuario(nombre, apellido, mail, contraseña);
    biblioteca.registrarUsuario(nuevoUsuario);

    JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente. Ahora puede iniciar sesión.");
}

    private static Usuario autenticarUsuario(Biblioteca biblioteca) {
    String mail = JOptionPane.showInputDialog("Ingrese su correo electrónico:");
    String contraseña = JOptionPane.showInputDialog("Ingrese su contraseña:");


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
                gestionarLibreria(biblioteca, usuario);
                break;
            case 2:
                buscarLibros(biblioteca);
                break;
            case 3:
                gestionarLibrosDesdeMenuBiblioteca(biblioteca, usuario);
                break;
            case 4:
                generarInforme(usuario);
                break;
            case 5:
                return; 
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
        }
    }
}

private static void gestionarLibrosDesdeMenuBiblioteca(Biblioteca biblioteca, Usuario usuario) {
    while (true) {
        int opcion = mostrarMenuGestionLibrosPrincipal();

        switch (opcion) {
            case 1:
                verListaLibros(biblioteca);
                break;
            case 2:
                alquilarLibro(biblioteca, usuario);
                break;
            case 3:
                devolverLibro(biblioteca, usuario);
                break;
            case 4:
                return; 
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
        }
    }
}

private static int mostrarMenuBiblioteca() {
    String[] opciones = {"Gestionar Libreria", "Buscar Libros", "Gestionar Biblioteca", "Generar Informe", "Salir a Menú Principal"};
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

private static int mostrarMenuGestionLibrosPrincipal() {
    String[] opciones = {"Ver Lista", "Alquilar Libro", "Devolver Libro", "Volver a Menú Principal"};
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



private static void gestionarLibreria(Biblioteca biblioteca, Usuario usuario) {
    while (true) {
        int opcion = mostrarMenuGestionLibreria();

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
                verListaLibros(biblioteca);
                break;
            case 5:
                return;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
        }
    }
}


private static int mostrarMenuGestionLibreria() {
    String[] opciones = {"Agregar Libro", "Eliminar Libro", "Editar Libro", "Ver Lista", "Volver a Menú de la Biblioteca"};
    return JOptionPane.showOptionDialog(
            null,
            "Gestión de la Biblioteca\nSeleccione una opción:",
            "Biblioteca App",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            opciones,
            opciones[0]
    ) + 1;
}

private static void verListaLibros(Biblioteca biblioteca) {
    List<Libro> todosLosLibros = biblioteca.getLibros();
    mostrarResultadosBusqueda(todosLosLibros, "Lista de todos los libros en la biblioteca:");
}

private static void agregarLibro(Biblioteca biblioteca) {
    String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
    if (titulo == null) {
        return;
    }

    String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
    String genero = JOptionPane.showInputDialog("Ingrese el género del libro:");
    if (autor == null || genero == null) {
        return;
    }

    Libro nuevoLibro = new Libro(titulo, autor, genero);
    biblioteca.agregarLibro(nuevoLibro);

    JOptionPane.showMessageDialog(null, "Libro agregado exitosamente: " + nuevoLibro.getTitulo());
}

private static void eliminarLibro(Biblioteca biblioteca) {
    String titulo = JOptionPane.showInputDialog("Ingrese el título del libro a eliminar:");
    if (titulo == null) {
        return;
    }

    if (biblioteca.eliminarLibro(titulo)) {
        JOptionPane.showMessageDialog(null, "Libro eliminado exitosamente: " + titulo);
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró un libro con el título proporcionado.");
    }
}


private static void editarLibro(Biblioteca biblioteca) {
    String titulo = JOptionPane.showInputDialog("Ingrese el título del libro a editar:");
    if (titulo == null) {
        return;
    }

    Libro libroExistente = biblioteca.buscarLibro(titulo);

    if (libroExistente != null) {
        String nuevoTitulo = JOptionPane.showInputDialog("Ingrese el nuevo título del libro:");
        if (nuevoTitulo == null) {
            return;
        }

        String nuevoAutor = JOptionPane.showInputDialog("Ingrese el nuevo autor del libro:");
        String nuevoGenero = JOptionPane.showInputDialog("Ingrese el nuevo género del libro");

        libroExistente.setTitulo(nuevoTitulo);
        libroExistente.setAutor(nuevoAutor);
        libroExistente.setGenero(nuevoGenero);

        JOptionPane.showMessageDialog(null, "Libro editado exitosamente. Nuevo título: " + nuevoTitulo);
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró un libro con el título proporcionado.");
    }
}




private static void buscarLibros(Biblioteca biblioteca) {
    String criterio = JOptionPane.showInputDialog("Ingrese la palabra clave para la búsqueda:");
    if (criterio == null) {
        return;
    }

    List<Libro> resultados = biblioteca.buscarLibrosPorPalabraClave(criterio);
    mostrarResultadosBusqueda(resultados, "Libros encontrados con la palabra clave:");
}

private static void alquilarLibro(Biblioteca biblioteca, Usuario usuario) {
    String titulo = JOptionPane.showInputDialog("Ingrese el título del libro a alquilar:");

    if (titulo == null) {
        JOptionPane.showMessageDialog(null, "Operación cancelada. Volviendo al menú de gestión de libros.");
        return;
    }

    if (biblioteca.alquilarLibro(usuario, titulo)) {
        JOptionPane.showMessageDialog(null, "Libro alquilado exitosamente: " + titulo);
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró un libro disponible con el título proporcionado.");
    }
}

private static void devolverLibro(Biblioteca biblioteca, Usuario usuario) {
    String titulo = JOptionPane.showInputDialog("Ingrese el título del libro a devolver:");

    if (titulo == null) {
        JOptionPane.showMessageDialog(null, "Operación cancelada. Volviendo al menú de gestión de libros.");
        return;
    }

    if (biblioteca.devolverLibro(usuario, titulo)) {
        JOptionPane.showMessageDialog(null, "Libro devuelto exitosamente: " + titulo);
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró un libro alquilado con el título proporcionado.");
    }
}


private static void generarInforme(Usuario usuario) {
    String informe = JOptionPane.showInputDialog("Escriba su informe o estadísticas sobre la biblioteca:");

    if (informe == null) {
        JOptionPane.showMessageDialog(null, "Generación de informe cancelada. Volviendo al menú de la biblioteca.");
        return;
    }

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
            String estado = libro.isAlquilado() ? "Alquilado" : "Disponible";
            mensajeResultados.append("- ").append(libro.getTitulo()).append(" (").append(libro.getAutor())
                    .append(") - ").append(estado).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensajeResultados.toString());
    }
}


}
