package StringManipulation;

import java.util.HashMap;
import java.util.Map;

/*
 * Write a function to count the occurrences of each character in a string. 
 * For example, for "mississippi", it should output {m:1, i:4, s:4, p:2}.
 */

public class CountOccuranceOfEachCharacter {

    public static void main(String[] args) {
        
        String input = "mississippi";

        Map<Character, Integer> map = new HashMap<>();
        for (Character singleChar : input.toCharArray()) {

            map.put(singleChar, map.getOrDefault(singleChar, 0)+1);

        }
        //you can directly print map
        System.out.println(map);

        //you can print map using entrySet
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());     
        }


    }
    
}
