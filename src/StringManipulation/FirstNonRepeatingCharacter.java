package StringManipulation;

import java.util.LinkedHashMap;

/*
 * Write a function to find the first non-repeating character in a given string.
 * If all characters repeat, return 0. For example, "swiss" should return 'w'.
 */

public class FirstNonRepeatingCharacter {

    char findFirstNonRepeatingCharacter(String input){

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(Character inputChar : input.toCharArray()) {
            map.put(inputChar, map.getOrDefault(inputChar,0)+1);
        }

        for(Character c : map.keySet()){
            if(map.get(c) == 1){
                return c;
            }
        }

        return '0';
    }

    public static void main(String[] args) {
        
        FirstNonRepeatingCharacter f = new FirstNonRepeatingCharacter();

        String[] inputStrings = {"swiss", "sunig", "aabbcc"};

        for(String input : inputStrings){
            char c = f.findFirstNonRepeatingCharacter(input);
            System.out.println("FirstNonRepeatingCharacter from" + input + " is -" + c);
        }

    }
    
}
