package StringManipulation;

/*
 * Implement a function to convert a string representation of an integer (with optional '+' or '-') into an actual integer.
 * Consider handling edge cases like " -42" and overflow conditions.
 * Consider below cases in manner of Input - Output - Explanation :-
 * 
 * "42" -> 42 -> 	Simple case with a positive integer.
 * " -42"->-42 ->    Leading spaces and a negative sign are handled.
 * "4193 with words" -> 4193 -> Parsing stops at the first non-numeric character after the digits start.
 * "words and 987"-> 0 ->The string starts with non-numeric characters, so it is invalid.
 * "-91283472332" -> -2147483648 -> Exceeds 32-bit integer min, capped at -2^31.
 * "2147483648"	-> 2147483647 -> Exceeds 32-bit integer max, capped at 2^31 - 1.
 * " "	-> 0   -> Only whitespace is considered invalid, returning 0. 
 */

public class ConvertStringToInteger {

    int atoIConverter(String input){
        int result = 0;

        input = input.trim();
        if(input.isEmpty()){
            return 0;
        }

        //parse the sign
        int index = 0;
        int sign = 1;

        if(input.charAt(index) == '-'){
            sign = -1;
            index++;
        }else if(input.charAt(index) == '+'){
            index++;
        }

        //parse the digits
        while(){}





        result = Integer.valueOf(input);
        
        

        return result;

    } 


    public static void main(String[] args) {
        ConvertStringToInteger atoI = new ConvertStringToInteger();
        System.out.println(atoI.atoIConverter("42"));
        System.out.println(atoI.atoIConverter("  -42"));
        System.out.println(atoI.atoIConverter("4193 with words"));
        System.out.println(atoI.atoIConverter("words and 987"));
        System.out.println(atoI.atoIConverter("-91283472332"));
        System.out.println(atoI.atoIConverter("2147483648"));
        System.out.println(atoI.atoIConverter(" "));

    }
    
}
