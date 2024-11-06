package StringManipulation;

import java.util.LinkedHashSet;

/*
 * Write a function to remove all duplicate characters from a given string.
 * For instance, for input "programming", the output should be "progamin".
 */

public class RemoveDuplicates{

    String removeDuplicates(String input){
        
        char[] stringArray = input.toCharArray();

        LinkedHashSet<Character> uniqueCharacters = new LinkedHashSet<>();
        for(char c : stringArray){
            uniqueCharacters.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for(char c : uniqueCharacters){
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        System.out.println(rd.removeDuplicates("programming"));
        System.out.println(rd.removeDuplicatesWithoutSet("programming"));
        System.out.println(rd.removeDuplicatesWithBooleanArray("programming"));

    }

    String removeDuplicatesWithoutSet(String input){
        
        //Step 1 : foreach character from input;
        //step 2 : if any character returns indexOf method as -1, skip that character
        //step 3 : continue while appending the characters
        //Step 4 : return the final string

        StringBuilder uniqueCharacters = new StringBuilder();
        for(char c :input.toCharArray()){
            if(uniqueCharacters.indexOf(String.valueOf(c)) == -1){
                uniqueCharacters.append(c);
            }
        }

        return uniqueCharacters.toString();
    }

    String removeDuplicatesWithBooleanArray(String input){

        //Step 1 : create boolean array of size 256 for ASCII chars
        //Step 2 : this boolean has 256 slots, all default values as false
        //Step 3 : foreach character to be added turn the flag of that slot to true
        //Step 4 : use if to check if any slot for any character has value as true, if yes skip that character 

        boolean[] seen = new boolean[256]; 

        StringBuilder uniqueString = new StringBuilder();
        for(char c : input.toCharArray()){
            if(!seen[c] == true){
                seen[c] = true;
                uniqueString.append(c);
            }
        }

        return uniqueString.toString();
    }

}