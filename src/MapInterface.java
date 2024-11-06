
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
public class MapInterface{

    public static void main(String args[]){
    
        //create a map of keys fruits and values as number
        Map<String,Integer> fruits = new HashMap<String, Integer>();
        fruits.put("Apples", 10);
        fruits.put("Banana",20);
        fruits.put("Mangoes", 5);

        //Get value by key
        String count = fruits.get("Banana").toString();
        System.out.println(count);

        //Iterating over keys
        for(String key : fruits.keySet()){

            System.out.println("Key - " + key + " - Values - "+ fruits.get(key) );
        }

        //Iterating over entries
        
        for(Map.Entry<String,Integer> entry : fruits.entrySet()){
            
            System.out.println("Key - " + entry.getKey() + " - Values - "+ entry.getValue());
        }

        //Get keySet
        System.out.println("KeySet - " + fruits.keySet());
        //Iterating on the Set of keys
        Set<String> keys = fruits.keySet();
        for(String key : keys){
            System.out.println("Fruit name - " + key);
        }
        
        //get value
        Collection<Integer> values = fruits.values();
        for(Integer value : values){
            System.out.println("All them values - " + value);
        }
        

    }

}

