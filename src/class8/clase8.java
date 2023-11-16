/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package class8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Usuario
 */
public class clase8 {
    
     public static void main(String[] args){
        
         //Ejemplo 1
         //HashMap Basico:
         //Crear un HashMap agregar elementos y mostrarlos
         Map<String, Integer>miMapa= new HashMap<>();
         
         //Agregamos informacion a este mapa 
         miMapa.put("Uno", 1);
         miMapa.put("Dos", 2);
         miMapa.put("Tres", 3);
         miMapa.put("Cuatro", 4);
         
         System.out.println("Ejemplo 1: " + miMapa);
         
         //Ejemplo2
         //Obtener el valor asociado a la clave dos
         int value = miMapa.get("Dos");
         System.out.println("value= " +value);
         
         //ejemplo3
         //verificar si la clase "Tres" esta presente en el mapa
         
         boolean containsKey = miMapa.containsKey("Cinco");
         System.out.println("Ejemplo3: ¿Contiene 'Cinco'? " + containsKey);
         
         //ejemplo4
         for(Map.Entry<String, Integer> entry: miMapa.entrySet()){
             System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
         }
         
         //Ejemplo 5 
         //LinkedHashMap: es una implementacion del map que mantiene el orden de
         //insercion de las claves. a diferencia del HashMap, donde no esta garantizado, Linked conserva
         //El orden en que se insertaron las entradas
         
         Map<String, Integer> miLinked = new LinkedHashMap<>();
         miLinked.put("Cinco", 5);
         miLinked.put("Seis", 6);
         
         System.out.println("Ejemplo 5: " + miLinked);
         
         //Ejemplo6
         //Utilizar un TreeMap para ordenar las claves de manera natural
         //TreeMap, es una implementacion de interfaz que ordena las claves de forma natural
         //o mediante un comparador personalizado a diferencia de hashmap y linkedhashmap las claves
         //en un treemap estan ordenadas
         Map<String, Integer> treeMap = new TreeMap<>(miLinked);
            treeMap.keySet().forEach(System.out::println);
            
         Map<String, Integer> miTree = new TreeMap<>();
         System.out.println("miTree = " + miTree);
         
         
            
            
        //Ejercicio1: tomar el mapa miMapa y remover un item
        System.out.println("Ejercicio 1: " + miMapa);
        miMapa.remove("Dos");
        System.out.println("Ejercicio 1: " + miMapa);
        
        //Ejercicio2: Tomar el mapa miMapa y reemplazar un item
        miMapa.put("Tres", 92);
        System.out.println("Ejercicio 2: " + miMapa);
         
         
     }
    
}
