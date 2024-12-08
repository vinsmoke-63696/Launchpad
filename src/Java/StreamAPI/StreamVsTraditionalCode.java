package Java.StreamAPI;
/*
 * You are given a list of integers, and you need to:
 * Filter out all numbers that are odd.
 * Multiply all the even numbers by 3.
 * Sort the resulting numbers in descending order.
 * Calculate the sum of the final list
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamVsTraditionalCode {

    public static void main(String[] args) {
        
        List<Integer> intList = Arrays.asList(1,2,3,5,6,7,9);

        int sum = 0;

        List<Integer> evenList = new ArrayList<>();

        for(Integer n : intList){
            if(n % 2 == 0){
                evenList.add(n * 3);  //Add to even list and multiply by 3
            }
        }

        evenList.sort(Comparator.reverseOrder());

        for(Integer n : evenList){
            sum = sum + n;
        }

        System.out.println(sum);
        ////////////Same Code but with Stream/////////////////
        int sum2 = 0;
        sum2 = intList.stream()
               .filter(n -> n % 2 == 0 )
               .map(n -> n * 3)
               .sorted(Comparator.reverseOrder())
               .mapToInt(Integer::intValue)
               .sum();
        System.out.println(sum2);        
    
    }
}
