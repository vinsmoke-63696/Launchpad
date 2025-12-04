package DSA.Day_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//input [1,4,3,2,6,5]   output [5,6,2,3,4,1]
//input [4,5,2]         output [2,5,4]
//input [1]             output [1]
public class ReverseAnArray {

    // Arrays -> fixed sized, defined at creation, cannot be changed later. stored
    // in continuous block, fast data access O(1)
    public static void main(String[] args) {

        //In place swap - best performance O(n)
        int[] input = { 1, 4, 3, 2, 6, 5 };
        int size = input.length;

        for (int i = 0; i < size / 2; i++) {
            int temp = input[i];
            input[i] = input[size - 1 - i];
            input[size - 1 - i] = temp;
        }

        System.out.println(Arrays.toString(input));
///////////////////////////////////////////////////////////////////
        // using Collections, works on wrapper, if its primitive then convert to wrapper

        int[] inputB = {1,4,3,2,6,5};
        //List<Integer> tempArray = Arrays.stream(inputB).boxed().toList(); // This approch won't work because immutability
        List<Integer> tempArray = new ArrayList<>();
        for(int a : inputB){
            tempArray.add(a);
        }

        Collections.reverse(tempArray);

        System.out.println(tempArray);
    }

}
