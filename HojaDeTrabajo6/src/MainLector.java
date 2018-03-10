
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
import java.util.InputMismatchException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jose Tejada
 * @author Guillermo Sandoval
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
      
    Map<String,String> mapaEnviar = null;
    MainLector main= new MainLector();
    Operaciones MiOperacion = null;
    MapFactory miFC= new MapFactory();
    Scanner entrada = new Scanner(System.in);
    
    boolean continuar = true;
    boolean continuar2=true;
    
    while(continuar ==true){
        //Un while para el menu que tiene metodo de seguridad contra valores fuera de rango
        //Y contra letras que pueda insertar el usuario 
        try{
            System.out.println("indique el tipo de implementacion que desea utilizar\n");
            System.out.println("1.HashMap \n 2.TreeMap \n 3.LinkedHashMap ");
            int opcion1 = entrada.nextInt();
            if(opcion1==1){
                
                mapaEnviar=miFC.getImplementacion(opcion1);
                main.leerYEnviar(mapaEnviar);
                continuar2 =true;
               
            }
            else if(opcion1==2){
                
                mapaEnviar=miFC.getImplementacion(opcion1);
                main.leerYEnviar(mapaEnviar);
                continuar2 =true;
            }
            else if(opcion1==3){
                 
                mapaEnviar=miFC.getImplementacion(opcion1);
                main.leerYEnviar(mapaEnviar);
                continuar2 =true;
            }
            else if(opcion1<1 || opcion1>3){
                System.out.println("Esa opcion no es valida, solo hay entre 1 y 3\n");
                continuar2 =false;
            }
        }
        catch (InputMismatchException e){
            System.out.println("Ingreso una o varias letras, vuelva a intentarlo");
            continuar2 =false;
            break;
        }
        
        while(continuar==true && continuar2==true){
            System.out.println("Ingrese el numero de la opcion que desea");
            System.out.println("1. Agregar una carta a la colección del usuario. Para esto el usuario ingresa el nombre de la carta que desea agregar a la misma.\n"
            +"2. Mostrar el tipo de una carta específica. El usuario ingresará el nombre de la carta y se muestra el tipo de esa carta.\n"
            +"3. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección.\n"
            +"4. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección, ordenadas por tipo.\n"
            +"5. Mostrar el nombre y tipo de todas las cartas existentes.\n"
            +"6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo.\n"
            +"7. Salir");
      
            
            try{
                //El segundo menu luego de usar implementacion con igual cantidad de progra defensiva al anterior
                int opcion2 = entrada.nextInt();
                if(opcion2==1){
                    System.out.println("OPCION 1");
               
                    String opcionS2;
                    String tipoS = null;
               
                    System.out.println("Escriba el nombre de su carta:");
                    System.out.println("");
                    //Por alguna razon si solo hay un entrada.nextLine no lee esto asi que se tuvo que usar doble
                    String cartaS = entrada.nextLine();
                    String cartaS1 = entrada.nextLine();
               
                try{
                    System.out.println("Escoja el tipo de su carta (NUMERO): \n 1.Monstruo \n 2. Hechizo \n 3. Trampa");
                    int opcion3 = entrada.nextInt();
                    if(opcion3==1){
                        System.out.println("Su carta es un Monstruo");
                        tipoS = "Monstruo";
               }
                    if(opcion3==2){
                        System.out.println("Su carta es un hechizo");
                        tipoS = "Hechizo";
               }
                    if(opcion3==3){
                        System.out.println("Su carta es una trampa");
                        tipoS = "Trampa";
               }
                    else if (opcion3<1 || opcion3>3){
                        System.out.println("Eso no esta entre las opciones, solo de 1 a 3\n");
                    }
               }catch(Exception e){
                   System.out.println("Esa opcion no esta disponible, escoja otra\n");
               }
               System.out.println("La carta: "+cartaS1+" del tipo: "+ tipoS +" Ha sido agregada");
               Operaciones.agregarCarta(cartaS1, tipoS);
            }
            if(opcion2==2){
                System.out.println("OPCION 2");
                System.out.println("EL VALOR DE LA CLAVE INGRESADA ES : "+Operaciones.getValorClave("Absorb Fusion"));
            }
            if(opcion2==3){
               Operaciones.imprimirInciso3();
                
            }
            if(opcion2==4){
                //Devuelve el resultado tanto para abajo como en linea por un pequeño error pero si lo arregla
                Map<String,String> mazo;
                mazo = Operaciones.setCantMazo(mapaEnviar);
                System.out.println(mazo);
            }
            if(opcion2==5){
                Operaciones.imprimirCartas();
            }
            if(opcion2==6){
                //Devuelve el resultado tanto para abajo como en linea por un pequeño error pero si lo arregla
                Map<String,String> mazo;
                mazo = Operaciones.inciso6(mapaEnviar);
                System.out.println(mazo);
            }
            if(opcion2==7){
                System.out.println("Gracias por usar el programa");
                continuar = false;
            }
            else if(opcion2<1 || opcion2>7){
            System.out.println("Esa opcion no es valida, solo hay entre 1 y 7\n");
        }
        }
        catch (InputMismatchException e) {
            System.out.println("Esa opcion no esta disponible o no ingreso el numero de la opcion\n");
            break;
        }
        }      
    }
       }
}