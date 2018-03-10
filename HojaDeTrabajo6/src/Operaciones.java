import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Guillermo Sandoval
 * @author Jose Tejada
 */
public class Operaciones {
   static   Map<String,String> mapaOp;
  
   public Operaciones(){
    //Constructor del codigo
   }
   
   public static void setMapa(Map<String,String> mapa){
    //Para construir un mapa Hash con key y value
       System.out.println("Mapa ingresado");
       Operaciones.mapaOp=mapa;
       
   }

    public static <K, V extends Comparable<? super V>> Map<K, V> setCantMazo(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo( o2.getValue() );
            }
        });
        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        
       Iterator<String> it = Operaciones.mapaOp.keySet().iterator();
       
       int monstruo = 0;
       int hechizo=0;
       int trampa=0;
        while(it.hasNext()){
        String key = it.next();
           switch (Operaciones.mapaOp.get(key)) {
               case "Monstruo":
                   monstruo++;
                   break;
               case "Hechizo":
                   hechizo++;
                   break;
               case "Trampa":
                   trampa++;
                   break;
               default:
                   break;
           }
   }
        String linea ="";
        for (Map.Entry<K, V> entryCol : result.entrySet()){
            linea += "Nombre Carta: " + entryCol.getKey()+"  ->  Tipo:"+ entryCol.getValue() + "\n";
        }
        System.out.println(linea);
        System.out.println("TOTAL MONSTRUO: "+monstruo + " TOTAL HECHIZOS: "+hechizo + " TOTAL TRAMPAS: "+ trampa);
    return result;
    }
   public static Map<String,String> getMapa(){
       return Operaciones.mapaOp;
   }
   
   public static  boolean validarValue(String Value){
       //Nos sirve para validar si un valor se encuentra al ir a buscarlo o no
       //Es booleano porque indica si el valor existe (verdadero) o si no existe (falso)
       boolean retorno=false;
       if (Operaciones.mapaOp.containsValue(Value)==true) {
           retorno=true;
       }
       else if (Operaciones.mapaOp.containsValue(Value)==false) {
           retorno=false;
           
       }
       return retorno;
   }
   
   public static boolean validarKey(String Key){
       //Nos sirve para verificar si contiene esa llave, es decir si existe, lo mismo que validarValue pero con la llave
       boolean retorno=false;
       if(Operaciones.mapaOp.containsKey(Key)==true){
           retorno=true;
       }
       else if (Operaciones.mapaOp.containsKey(Key)==false) {
           retorno=false;
       }
       return retorno;
   }
   
   public static void agregarCarta(String Key, String Value){
       //Lo que hace es validar si existe un valor que ya exista para limitar que solo esten Monstruo, Hechizo y Trampa
       //Y ademas verifica que la llave no este ocupada, sino nos da error porque tal carta ya existiria
       if ((validarValue(Value)==true)&&(validarKey(Key)==false)) {
           Operaciones.mapaOp.put(Key, Value);

           System.out.println("Carta Ingresada con éxito");
       }
       else if ((validarKey(Key)==true)&&(validarValue(Value)==true)) {
          
           
            System.out.println("ERROR: Ingresaste un Tipo correcto pero el nombre YA EXISTE.");
       }
       else if ((validarValue(Value)==false)&&(validarKey(Key)==false)) {
           
            
             System.out.println("ERROR: Ingresaste una carta con nombre posible, pero el tipo NO EXISTE");
       }
       else if ((validarValue(Value)==false)&&(validarKey(Key)==true)) {
           
            System.out.println("ERROR: CARTA NO INGRESADA, Tipo no encontrado y el nombre ya existe");
       }
       }
   
   public static String getValorClave(String Key){
       return Operaciones.mapaOp.get(Key);
   }
   
   public static void imprimirInciso3(){
       //El inciso 3 nos pide saber cuantas cartas hay de cada tipo, para ello se uso un iterador
       //Al iniciar todo se encuentra en 0 y el iterador recorre por llave el valor, si detecta que el valor
       //Ya se encoontraba antes les suma uno al valor y asi sigue recorriendo toda la lista de cartas.
       Iterator<String> it = Operaciones.mapaOp.keySet().iterator();
       int monstruo = 0;
       int hechizo=0;
       int trampa=0;
    while(it.hasNext()){
      String key = it.next();
      System.out.println("Nombre Carta: " + key + " -> Tipo: " + Operaciones.mapaOp.get(key));
           switch (Operaciones.mapaOp.get(key)) {
               case "Monstruo":
                   monstruo++;
                   break;
               case "Hechizo":
                   hechizo++;
                   break;
               case "Trampa":
                   trampa++;
                   break;
               default:
                   break;
           }
    }
       System.out.println("TOTAL MONSTRUO: "+monstruo + " TOTAL HECHIZOS: "+hechizo + " TOTAL TRAMPAS: "+ trampa);
   }
   
   public static void imprimirCartas(){
       //Simplemente pasa por todo el mapa e imprime todos los valores junto a sus llaves unicas
       System.out.println("TODAS LAS CARTAS: ");
        Iterator<String> it = Operaciones.mapaOp.keySet().iterator();
        while(it.hasNext()){
          String key = it.next();
          System.out.println("Clave: " + key + " -> Valor: " + Operaciones.mapaOp.get(key));
        }
   }
   public static <K, V extends Comparable<? super V>> Map<K, V> inciso6(Map<K, V> map){
        //En el inciso 6 se nos pide ordenar las cartas por su tipo
        //La forma mas facil era solamente imprimiendo primero todas las de valor Monstruo
        //Luego las de valor Hechizo y luego Trampa.
        //Pero para que quede ordenado alphabeticamente por valor decidimos usar el codigo de 
        //sorting que emplea comparable, esto se encontro en StackOverflow pero vamos a explicarlo
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        //Para comparar el comparable lo que hace es como valores, si el valor de 1 es menor al de 2 va arriba
        //Nos regresa la comparacion del valor, la forma de hacerlo es por medio de decir si el tipo de la carta
        //ya esta, por sus letras, por ejemplo Hechizo, la H es previa a la M y a la T, por lo que todos los Hechizos
        //Van de primero.
        Collections.sort( list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> valor1, Map.Entry<K, V> valor2) {
                return (valor1.getValue()).compareTo( valor2.getValue() );
            }
        });
        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        String linea ="";
        for (Map.Entry<K, V> entryCol : result.entrySet()){
            linea += "Nombre Carta: " + entryCol.getKey()+"  ->  Tipo:"+ entryCol.getValue() + "\n";
        }
        System.out.println(linea);
        return result;
   }
}

