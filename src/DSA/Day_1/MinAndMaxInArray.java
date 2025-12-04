package DSA.Day_1;

import java.util.Arrays;
import java.util.List;

//Find the minimum and maximum number from an array and return the pair

//input [5,2,1,56,10000,167]   output [1,10000]
//input [1,345,234,21,56789]   output [1,56789]
//input [56789]                output [56789]

public class MinAndMaxInArray {
    public static void main(String[] args) {
        // sort the array and then get first and last
        int[] input = { 5, 2, 1, 56, 10000, 167 };
        List<Integer> sorted = Arrays.stream(input).boxed().sorted().toList();
        System.out.println(sorted.get(0) + " " +sorted.get(sorted.size()-1));
        
        // using hardcore bubble sorting : at each pass, the largest value goes to last place
        for(int i = 0; i< input.length -1 ; i++){   
            for(int j = 0; j<input.length - 1 - i; j++){
                if(input[j] > input[j + 1]){
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            //    System.out.println(Arrays.toString(input));
            }                    
        }
        System.out.println(input[0] + " " + input[input.length-1]);

    }

}
