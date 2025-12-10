package DSA.Day_2;

import java.util.Arrays;

//input = { 1, -1, 3, 2, -7, -5, 11, 6 };  output {1,3,2,11,6,-1,-7,-5}
//All positives on left, all negatives on right
public class MoveNegative {
    public static void main(String[] args) {
        int[] input = { 1, -1, 3, 2, -7, -5, 11, 6 };
        int length = input.length - 1;

        int leftPoint = 0;
        int temp;
        for (int i = 0; i <= length; i++) {
            if (input[i] > 0) {

                temp = input[leftPoint];
                input[leftPoint] = input[i];
                input[i] = temp;

                leftPoint++;
            }
        }
        System.out.println(Arrays.toString(input));

        // Above method does not preserve order and has Time complexity of O(n), and if
        // we want to preserve order and do it in place,
        // we will have to loop and move lots of numbers this will increate time
        // complexity making it inefficient
        // The better appraoch is to use Auxiliary array and then copy the content back
        // to original array.

        int[] input2 = { 1, -1, 3, 2, -7, -5, 11, 6 };

        int[] auxiliary = new int[input2.length];
        int j = 0;
        for (int i = 0; i < input2.length; i++) {
            if (input2[i] > 0) {
                auxiliary[j++] = input2[i];
            }
        }

        for (int i = 0; i < input2.length; i++) {
            if (input2[i] < 0){
                auxiliary[j++] = input2[i];
            }
        }

        for(int i = 0; i< input2.length; i++){
            input2[i] = auxiliary[i];
        }

        System.out.println(Arrays.toString(auxiliary));
    }
}
