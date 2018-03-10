import java.util.Iterator;
import java.util.Map;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Clase de Operaciones para las selecciones del Usuario
 * @author Jose Tejada
 * @author Guillermo Sandoval
 * @version 1.0
 */
public class Operaciones {
   static   Map<String,String> mapaOp;
  
   public Operaciones(){
     
   }
   
   public static void setMapa(Map<String,String> mapa){
       System.out.println("Mapa ingreado");
       Operaciones.mapaOp=mapa;
       
   }
   
   public static Map<String,String> getMapa(){
       return Operaciones.mapaOp;
   }
   
   public static  boolean validarValue(String Value){
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
       System.out.println("TODAS LAS CARTAS: ");
        Iterator<String> it = Operaciones.mapaOp.keySet().iterator();
        while(it.hasNext()){
          String key = it.next();
          System.out.println("Clave: " + key + " -> Valor: " + Operaciones.mapaOp.get(key));
        }
   }
}