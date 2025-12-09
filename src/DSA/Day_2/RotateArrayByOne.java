package DSA.Day_2;

import java.util.Arrays;

//Rotate array by 1, last element becomes first
public class RotateArrayByOne {

    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 4, 5, 3 };

        int lastElement = input[input.length - 1];
        for (int i = input.length - 1; i > 0; i--) {
            input[i] = input[i - 1];
        }
        input[0] = lastElement;

        System.out.println(Arrays.toString(input));
    }
}
