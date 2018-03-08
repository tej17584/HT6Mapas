
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
       public static void main(String[] arg) {
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
             
         }
         
     
           
         
        
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
}
