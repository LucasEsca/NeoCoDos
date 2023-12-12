package class_14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    
    public static void main(String[] args) {
    
        List<String> listaPalabras = Arrays.asList("Java", "es", "genial", "y", "potente");
        
        //filtrar palabras con longitud mayor a 3 y convertirlas a mayusculas
        List<String> palabrasFiltradas = listaPalabras.stream()
                .filter(palabra->palabra.length() > 3)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        
        //imprimimos las palabras filtradas y convertidas a mayusculas
        palabrasFiltradas.forEach(System.out::println);
    }
    
}
