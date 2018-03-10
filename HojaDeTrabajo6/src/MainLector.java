
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jose Tejada
 */
public class MainLector {
    public void leerYEnviar(Map<String,String> mapaEnviar){
        File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
         try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         fr= new FileReader("cards_desc.txt");
         br = new BufferedReader(fr);

         // Lectura del fichero
          // Lectura del fichero
         String linea;
         String Key;
         String Value;
         int posicion;
         while((linea=br.readLine())!=null){
             posicion=linea.indexOf("|");
             Key=linea.substring(0, posicion);
             Value=linea.substring(posicion+1, linea.length());  
             mapaEnviar.put(Key, Value);
         }
         Operaciones.setMapa(mapaEnviar);
      }
      catch(IOException e){
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (IOException e2){ 
         }
      }
    }
   
       public static void main(String[] arg) {
      
      Map<String,String> mapaEnviar;
     MainLector main= new MainLector();
     Operaciones MiOperacion = null;
     MapFactory miFC= new MapFactory();
Scanner entrada = new Scanner(System.in);
    
          
    System.out.println("indique el tipo de implementacion que desea utilizar\n");
    System.out.println("1.HashMap \n 2.TreeMap \n 3.LinkedHashMap \n");
    
    int opcion1 = 0;
    String opcionS;
    boolean continuar = true;
    while(continuar ==true){
    opcionS = entrada.nextLine();
    opcion1 = Integer.parseInt(opcionS);
        try{
            
            if(opcion1==1){
                
                mapaEnviar=miFC.getImplementacion(opcion1);
                main.leerYEnviar(mapaEnviar);
               
            }
            if(opcion1==2){
                
                mapaEnviar=miFC.getImplementacion(opcion1);
                main.leerYEnviar(mapaEnviar);
            }
            if(opcion1==3){
                 
                mapaEnviar=miFC.getImplementacion(opcion1);
                main.leerYEnviar(mapaEnviar);
            }
        int opcion2;
        System.out.println("1. Agregar una carta a la colección del usuario. Para esto el usuario ingresa el nombre de la carta que desea agregar a la misma.\n"
        +"2. Mostrar el tipo de una carta específica. El usuario ingresará el nombre de la carta y se muestra el tipo de esa carta.\n"
        +"3. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección.\n"
        +"4. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección, ordenadas por tipo.\n"
        +"5. Mostrar el nombre y tipo de todas las cartas existentes.\n"
        +"6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo.");
      
        opcionS = entrada.nextLine();
        opcion2 = Integer.parseInt(opcionS);
            if(opcion2==1){
               System.out.println("OPCION 1");
               Operaciones.agregarCarta("Texas Spell", "Hechizo");
            }
            if(opcion2==2){
                System.out.println("OPCION 2");
                System.out.println("EL VALOR DE LA CLAVE INGRESADA ES : "+Operaciones.getValorClave("Absorb Fusion"));
            }
            if(opcion2==3){
               Operaciones.imprimirInciso3();
                
            }
            if(opcion2==4){
                
            }
            if(opcion2==5){
                Operaciones.imprimirCartas();
            }
            if(opcion2==6){
                
            }
            if(opcion2==7){
                System.out.println("Gracias por usar el programa");
                continuar = false;
            }
            
        }
        catch (NumberFormatException e) {
            System.out.println("Esa opcion no esta disponible o no ingreso el numero de la opcion");
        }
    }  
        
    }
}
