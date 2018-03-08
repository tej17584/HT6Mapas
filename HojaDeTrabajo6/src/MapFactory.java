
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
 *
 * @author Jose Tejada
 */
public class MapFactory {
    
    public Map<String,String> getImplementacion(int implementacion){
        switch (implementacion) {
            case 1:
                System.out.println("USASTE HASMAP");
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
