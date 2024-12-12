package Java.Algorithms;
//Find the length of longest consecutive sequence of numbers in unsorted array
//input array = {100,4,200,1,3,2};
//output 4 for {1,2,3,4}

//This needs refactoring
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSequence {

    int getLongestLength(int[] input){
        int longestSequence = 0;

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i : input){
            set.add(i);
            list.add(i);
        }




        for(int i : list){
            if(set.contains(i-1)){
                int currentStreak = 0;
                while(set.contains(i-1)){
                    currentStreak++;
                    i++;
                }

                longestSequence = Math.max(currentStreak, longestSequence);
            }
        }


        return longestSequence;
    }


    public static void main(String[] args) {
        LongestConsecutiveSequence ls = new LongestConsecutiveSequence();
        int[] array = {100,4,200,1,3,2};
        int ouput = ls.getLongestLength(array);
        System.out.println(ouput);
    }
    
}
