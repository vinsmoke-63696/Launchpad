package Java.Algorithms;
//Given an array of integer and a target sum, find all unique pair of numbers that add up to a target sum.
//input Array: [2, 4, 3, 5, 6, -2, 4, 7], Target: 8
//output Pairs: [[2, 6], [3, 5], [4, 4]]

//Solving with brute force

import java.util.ArrayList;
import java.util.List;

public class TwoSum {

    List<List<Integer>> twoSum(int[] input, int target){
        List<Integer> inputList = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        for(int i : input){
            inputList.add(i);
        }

        for(int i : input){
            if(inputList.contains(target - i)){
                List<Integer> subList = new ArrayList<>();
                subList.add(Math.min(i, target-i));
                subList.add((Math.max(i, target-i)));

                if(!output.contains(subList)){
                    output.add(subList);
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        
        int[] input = {2,4,3,5,6,-2,4,7};
        int target = 8;

        TwoSum ts = new TwoSum();

        List<List<Integer>> output = ts.twoSum(input, target); 
        System.out.println(output);

    }
}
