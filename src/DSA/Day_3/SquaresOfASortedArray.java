package DSA.Day_3;

import java.util.Arrays;

//return an sorted array containing the squares of each number
//input [-4,-1,0,3,10] output [0,1,9,16,100]
//input [-7,-3,2,3,11] output [4,9,9,49,121]
public class SquaresOfASortedArray {
    public static void main(String[] args) {

        int[] input = { -3, 2, 3};

        int size = input.length - 1;
        int[] output = new int[input.length];

        int left = 0;
        int right = input.length - 1;

        while (left <= right) {
            if (input[left] * input[left] > input[right] * input[right]) {
                output[size] = input[left] * input[left];
                left++;
            } else {
                output[size] = input[right] * input[right];
                right--;
            }
            size--;
        }
        System.out.println(Arrays.toString(output));
    }
}
