package DSA.Day_2;

import java.util.Arrays;

//insert 0 whenever 0 is encounterd in array and move the rest of the elements to right. modify the array in-place
//input {1,0,3,0,4,5,6,0}; output {1,0,0,3,0,0,4,5}
public class DuplicateZeroes {

    public static void main(String[] args) {
        int[] input = { 1, 0, 3, 0, 4, 5, 6, 0 };

        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] == 0) {

                for (int j = input.length - 1; j > i; j--) {

                    input[j] = input[j - 1];
                }

                input[i + 1] = 0;
                i++;

            }
        }
        System.out.println(Arrays.toString(input));

    }
}
