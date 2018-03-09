
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
public class Operaciones {
   Map<String,String> mapaOp;
   
   public Operaciones(){
       
   }
   
   public void setMapa(Map<String,String> mapa){
       this.mapaOp=mapa;
   }
   
   public Map<String,String> getMapa(){
       return this.mapaOp;
   }
   
   public boolean validarValue(String Value){
       boolean retorno=false;
       if (this.mapaOp.containsValue(Value)==true) {
           retorno=true;
       }
       else if (this.mapaOp.containsValue(Value)==false) {
           retorno=false;
           
       }
       return retorno;
   }
   
   public boolean validarKey(String Key){
       boolean retorno=false;
       if(this.mapaOp.containsKey(Key)==true){
           retorno=true;
       }
       else if (this.mapaOp.containsKey(Key)==false) {
           retorno=false;
       }
       return retorno;
   }
   
   public void agregarCarta(String Key, String Value){
       
   }
   
 
}
