package DSA.Day_1;

import java.util.ArrayList;
import java.util.List;

//Given array of integer nums, determine the number of elements that contain an even number of digits
public class FindNumbersWithEvenNumberOfDigits {

    public static void main(String[] args) {
        int[] input = { 12, 345, 2, 6, 7896, 161214 }; // output = 3

        List<String> list = new ArrayList<>();
        for (int a : input) {
            list.add(String.valueOf(a));
        }

        Long count = list.stream().filter(n -> n.length() % 2 == 0).count();

        System.out.println(count);

    }

}
