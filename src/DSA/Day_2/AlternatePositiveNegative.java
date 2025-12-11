package DSA.Day_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//rearrange unsorted array with postive and negative numbers in it. 
//should start with positive number and maintain relative order
//input[9,4,-2,-1,5,0,-5,-3,2]  output[9,-2,4,-1,5,-5,0,-3,2]
//input2 [-5,-2,5,2,4,7,1,8,0,-8] output2 [5,-5,2,-2,4,-8,7,1,8,0]
public class AlternatePositiveNegative {

    public static void main(String[] args) {
        int[] input = { 9, 4, -2, -1, 5, 0, -5, -3, 2, 6 };

        List<Integer> postives = new ArrayList<Integer>();
        List<Integer> negative = new ArrayList<Integer>();

        for (int i = 0; i < input.length; i++) {

            if (input[i] >= 0) {
                postives.add(input[i]);
            } else {
                negative.add(input[i]);
            }
        }

        int i = 0;
        int p = 0;
        int n = 0;

        while (p < postives.size() && n < negative.size()) {
            input[i] = postives.get(p);
            i++;
            p++;
            input[i] = negative.get(n);
            i++;
            n++;
        }

        while (p < postives.size()) {
            input[i] = postives.get(p);
            i++;
            p++;
        }

        while (n < negative.size()) {
            input[i] = negative.get(n);
            i++;
            n++;
        }

        System.out.println(Arrays.toString(input));

    }

}
