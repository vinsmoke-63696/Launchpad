package Java.StreamAPI.BasicLevel;

import java.util.List;

public class BasicLevel {

    public static void main(String[] args) {
        
        //Find Strings Starting with 'A': From a list of strings, find all strings that start with the letter 'A' and convert them to uppercase.
        List<String> output = List.of("Antique","Anna","Curt","Stream","amy").stream()
                                    .filter(n -> n.charAt(0) == 'A' || n.charAt(0) == 'a')
                                    .map(String::toUpperCase).toList();
        System.out.println(output);
    
    //Calculate sum of all numbers in list
    Integer sumAll = List.of(1,2,3,4,5,6).stream()
                                    .reduce(0, Integer::sum);
        System.out.println(sumAll);

    //find the count of string greater than length 5 in given list
    long count = List.of("Sam", "Altman","Junior", "Senior","nooby").stream()
                                    .filter( n -> n.length() > 5)
                                    .count();
        System.out.println(count);


    }
        
}
