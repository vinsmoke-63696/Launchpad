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

        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;

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
        int num = 0;
        while(index < input.length() && Character.isDigit(input.charAt(index))){
            int digit = input.charAt(index) - '0';  // we need to subtract '0' to convert from ASCII to Integer. eg. '5' - '0' results in 53 - 48, which equals 5

            //check overflow condition
            if(num > (maxInt - digit )/ 10){
                return sign == 1 ? maxInt : minInt;
            }

            num = num * 10 + digit;
            index++;
        }

        return sign * num;      
    } 


    public static void main(String[] args) {
        ConvertStringToInteger atoI = new ConvertStringToInteger();
        System.out.println(atoI.atoIConverter("42"));  //op - 42
        System.out.println(atoI.atoIConverter("  -42")); //op - -42
        System.out.println(atoI.atoIConverter("4193 with words")); //op - 4193
        System.out.println(atoI.atoIConverter("words and 987")); //op - 0
        System.out.println(atoI.atoIConverter("-91283472332")); // op - -2147483648
        System.out.println(atoI.atoIConverter("2147483648")); //op - 2147483647
        System.out.println(atoI.atoIConverter(" ")); //op - 0

    }
    
}
