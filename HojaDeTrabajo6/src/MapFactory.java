
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *Clase Factory para seleccionar una implementacion.
 * @author Jose Tejada
 * @author Guillermo Sandoval
 * @version 1.0
 */
public class MapFactory {
    /**
     * Este es Factory.Esta clase sirve para seleccionar la instancia que usaremos.  
     * @param implementacion es un int que se selecciona par ala implementacion
     * @return una nueva implementacion de Map
     */
    public Map<String,String> getImplementacion(int implementacion){
        switch (implementacion) {
            case 1:
                System.out.println("USASTE HASHMAP");
                return new HashMap<>();
            case 2:
                System.out.println("USASTE TREEMAP");
                return new TreeMap<>();
            case 3:
                System.out.println("USASTE LINKEDHASMAP");
                return new LinkedHashMap<>();
            default:
                break;
        }
        return null;
    }
}
