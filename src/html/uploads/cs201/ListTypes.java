package classexamples;

import java.util.ArrayList;
import java.util.HashMap;

public class ListTypes {
    
    public static void main(String[] args) {
        //Using an ArrayList to store a String array
        ArrayList<String> titles = new ArrayList<String>(5);
        titles.add("Super Mario Galaxy");
        titles.add("The Legend of Zelda: Ocarina of Time");
        titles.add("Super Mario Galaxy 2");
        titles.add("Grand Theft Auto IV");
        titles.add("Soul Caliber");
        
        //Use a foreach loop if you do not need to track the index of the current element
        for(String item : titles) {
            System.out.println(item);
        }
        
        //Using a HashMap to pair games with their scores
        //Note the use of the Double object, not the primitive
        HashMap<String, Double> games = new HashMap<String, Double>();
        games.put("Super Mario Galaxy", new Double(97.6));
        games.put("The Legend of Zelda: Ocarina of Time", new Double(97.4));
        games.put("Super Mario Galaxy 2", new Double(97.2));
        
        //Hashmaps are not iterable, but their keys are if you use keySet()
        for(String key : games.keySet()) {
            System.out.println(key + " " + games.get(key));
            
        }
        
        
        

        
        
    }
}
