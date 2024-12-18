package Java.StreamAPI.IntermediateLevel;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class IntermediateLevel {
    
    public static void main(String[] args) {
        
    //Find max and min values from list of integers
    List<Integer> input = List.of(1,2,3,4,5,6);
    Integer min = input.stream().sorted().findFirst().get();
    Integer max = input.stream().sorted(Comparator.reverseOrder()).findFirst().get();
    System.out.println("Min is -> " + min + " & Max is -> " + max);

    //Convert List to Map - where key is String and value is length
    Map<String, Integer> map = List.of("Amazon", "Riddle", "Puzzle", "Google","rizz").stream()
                                .collect(Collectors.toMap(
                                    n -> n.toString(),  //key mapper
                                    String::length,      //value mapper
                                    (oldValue, newValue) -> newValue //Merge function (keep old value) avoid duplicates
                                ));
        System.out.println(map);

    //Find second highest number in a list of integer
    Integer num = List.of(1,2,3,4,5,6).stream()
                    .sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(num);

    
    //Find duplicate elements in list of integers
    Set<Integer> set = new HashSet<>();
    Set<Integer> outSet = List.of(1,2,2,3,4,4,5,6,7,7,7,8).stream()
                    .filter(n -> !set.add(n))
                    .collect(Collectors.toSet());
        System.out.println(outSet);

        

    }

}
