package class_14Bis;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] arg){
    
        //creamos una lista de autos
        List<Auto> listaAutos = new ArrayList<>();
        listaAutos.add(new Auto("Fiat","Uno"));
        listaAutos.add(new Auto("Gol","Trend"));
        listaAutos.add(new Auto("Chevrolet","Corsa"));
        listaAutos.add(new Auto("Chevrolet","Corvette"));
        
        //Uso de strams para filtrar los autos y mostrar los que esten en marcha
        System.out.println("Autos en marcha: " );
        listaAutos.stream()
                .filter(Auto::isEnMarcha)
                .forEach(System.out::println);
        
        //cambiar el estado (enMarcha) de todos los autos a true usando Streams
        System.out.println("\nArranco todos los autos...");
                listaAutos.stream()
                .forEach(auto->auto.setEnMarcha(true));
       
        //mostrar todos los autos desp de arrancarlos
        System.out.println("\nEstado de todos los autos despus de arrancar:");
        listaAutos.forEach(System.out::println);
        
    }
}
