package StringManipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * For example, "abcabcbb" should return 3 for substring "abc".
 */
public class LongestSubstringNoRepetation {

    public static void main(String[] args) {
        
        String input = "abcabcbbpqrs";  //pqrstuvwxyz
        int maxLength = 0;
        int start = 0;

        Set<Character> characterSet = new HashSet<>();

        for(int end = 0; end < input.length(); end++){

            char currentChar = input.charAt(end);
            //abcabcbbpqrs

            while(characterSet.contains(currentChar)){
                characterSet.remove(input.charAt(start));
                start++;
            }

            characterSet.add(currentChar);

            maxLength = Math.max(maxLength, end-start + 1);

        }

        System.out.println(maxLength);

    }
}