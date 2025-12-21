package DSA.Day_2;

import java.util.Arrays;

//Remove all occurances of val in nums-in-place. Return the number of elements not equal to val
//input [3,2,2,3] val = 3   output 2, [2,2,_,_]
//input [0,1,2,2,3,0,4,2] val = 2 output 5, [0,1,4,0,3,_,_,_] 
public class RemoveElement {

    public static void main(String[] args) {
        int[] input = { 1,4,3,0,0,4,3 };
        int val = 0;

        int index = 0;
        for (int i = 0; i < input.length; i++) {

            if (input[i] != val) {
                input[index] = input[i];
                index++;
            }
        }

        for(int i = index; i< input.length; i++){
            input[i] = -1;
        }

        System.out.println(index);
         System.out.println(Arrays.toString(input));
    }
}
