/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package class7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Usuario
 */
public class class7 {
    
    public static void main(String[] args){
    
        /*
        //Ejemplo basico de lista
        //crear una lista
        //List: la clase q usamos
        //<String>:declaramos el tipo de dato de la lista
        //miLista: el nombre de la lista
        //new: palabra reservada que nos indica el tipo de implementacion
        //ArrayList<>(): la implementacion
        List<String> miLista = new ArrayList<>();
        
        //agregamos elementos a la lista con el metodo add
        miLista.add("Manzana");
        miLista.add("Banana");
        miLista.add("Frutilla");
        
        
        //Accedemos a elementos por indice
        //con la palabra get obtenemos el indice
        String primeraFruta = miLista.get(0);
        System.out.println("Primera fruta: " + primeraFruta);
        
        //iterar a travez de una lista
        for(String fruta: miLista){
            System.out.println("Fruta: " + fruta);
        }
        
        
        //Set
        //crear un conjunto
        Set<String>miSet = new HashSet<>();
        
        miSet.add("Kiwi");
        miSet.add("Mandarina");
        miSet.add("Melon");
        
        for(String fruta : miSet){
            System.out.println("Fruta: " + fruta);
        }*/
        
        Map<String, Integer> miMapa = new HashMap<>();
        
        miMapa.put("Zapato", 9);
        miMapa.put("Remeras", 10);
        miMapa.put("Cartera", 7);
        
        int cantidadZapato = miMapa.get("Zapato");
        System.out.println("Cantidad de Zapatod: " + cantidadZapato);
        
        for(String producto: miMapa.keySet()){
            int cantidad = miMapa.get(producto);
            System.out.println("Productos: " + producto + " Cantidad: " + cantidad);
        }
        
        
    }
}
