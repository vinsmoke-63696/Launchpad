package StringManipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 *Write a function to check if two strings are anagrams of each other. 
 *For instance, "listen" and "silent" are anagrams. Ignore case and spaces for this problem. 
 */

public class AnagramChecker{

    boolean AreAnagram(String inputA, String inputB){
        boolean isAnagram = false;

        if(inputA.length() != inputB.length())
            return isAnagram;

        char[] inputAChar = inputA.toCharArray();
        Arrays.sort(inputAChar);

        char[] inputBChar = inputB.toCharArray();
        Arrays.sort(inputBChar);

        if(Arrays.equals(inputAChar, inputBChar))
            isAnagram = true;

        return isAnagram;
    }

    public static void main(String[] args) {
        AnagramChecker ac = new AnagramChecker();
        String inputA = "listen";
        String inputB = "silent";
        boolean isAnagram = ac.AreAnagram(inputA, inputB);
        
        boolean isAnagramWithHashMap = ac.AreAnagramWithHashMap(inputA,inputB);
        System.out.println(isAnagram);
        System.out.println(isAnagramWithHashMap);
    }

    boolean AreAnagramWithHashMap(String inputA, String inputB){

        if(inputA.length() != inputB.length())
        return false;

        //Step 1 - store all the characters of string 1 as a key and their count as a value in hashmap
        //output - s-1, i-1, l-1, e-1, n-1, t-1

        //step 2 - for every character from string 2, get the key from hashmap and reduce its value by 1

        //step 3 - if any character from string 2,if the key is not present or if the value from the hashmap is reduced to 0, return false
        //explanation - this means that there are more characters of same key in string 2 than string 1

        //step 4- if step 3 does not return false, return true


        //Step 1
        Map<Character,Integer> inputAHash = new HashMap<Character,Integer>();
        char[] inputAChar = inputA.toCharArray();

        for(char c : inputAChar){
            inputAHash.put(c, inputAHash.getOrDefault(c, 0) + 1);
        }

        //output of step 1
        for(Map.Entry<Character,Integer> entry : inputAHash.entrySet()){
            System.out.println("char - " + entry.getKey() + " - value - " + entry.getValue());
        }

        //step 2
        for(char c : inputB.toCharArray()){

            if(!inputAHash.containsKey(c) || inputAHash.get(c) == 0)
                return false;

            inputAHash.put(c,inputAHash.get(c) - 1);
        }
        
        return true;
    }

}