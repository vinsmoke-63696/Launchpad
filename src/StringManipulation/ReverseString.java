package StringManipulation;

/*
 * Given a string s, reverse the order of words in it. 
 * For example, given the input "hello world", the output should be "world hello". 
 * You should consider consecutive spaces as a single space.
 */

public class ReverseString {
    public static void main(String[] args) {

        String input = "Hello     world I live in India     ";

        System.out.println(input);

        // \\s is the regex to identify space and + denotes occurances of more than 1 space
        String[] splittedStrings = input.split("\\s+");
    
        //check if split works
        for(String string : splittedStrings){
            System.out.println(string);
        }
        System.out.println(splittedStrings.length);
        
        //reverse the string
        StringBuilder output = new StringBuilder();

        for(int i = splittedStrings.length; i>0; i--){
           output.append(splittedStrings[i-1]);
           if(i>1){
            output.append(" ");
           }     
        }
        
        System.out.println(output + "length is - " + output.length());
    }
}
