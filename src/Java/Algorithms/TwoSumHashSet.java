package Java.Algorithms;
//Given an array of integer and a target sum, find all unique pair of numbers that add up to a target sum.
//input Array: [2, 4, 3, 5, 6, -2, 4, 7], Target: 8
//output Pairs: [[2, 6], [3, 5], [4, 4]]

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Solving with Best Approach

public class TwoSumHashSet {

    private List<List<Integer>> twoSum(int[] input, int target){

        List<List<Integer>> output = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i : input){
            if(set.contains(target - i)){
                List<Integer> subList = new ArrayList<>();
                subList.add(Math.min(i, target-i));
                subList.add(Math.max(i, target-i));

                if(!output.contains(subList)){
                    output.add(subList);
                }
            }
            set.add(i);
        }
        return output;
    } 

    public static void main(String[] args) {
        int[] input = {2,4,3,5,6,-2,4,7};
        int target = 8;

        TwoSumHashSet ts = new TwoSumHashSet();
        List<List<Integer>> output = ts.twoSum(input, target);
        System.out.println(output);
        
    }

}