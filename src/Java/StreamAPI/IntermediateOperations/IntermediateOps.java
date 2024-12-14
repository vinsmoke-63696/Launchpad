package Java.StreamAPI.IntermediateOperations;

import java.util.ArrayList;
import java.util.List;

public class IntermediateOps {

    public static void main(String[] args) {
        
        //filter even numbers from list of integers
        int[] list = {1,2,3,4,5,6,7,8};
        List<Integer> input = new ArrayList<>();
        for(int i : list){
            input.add(i);
        }

        //1. Filter  --even
        List<Integer> output = input.stream().filter(n -> n % 2 == 0).toList();
        System.out.println(output);
        
        //2. Map   -- uppercase
        List<String> input2 = List.of("bob", "alice", "suzan");
        input2 = input2.stream().map(String::toUpperCase).toList(); //:: is called Method Reference Operator
        System.out.println(input2);

        //3. Flatmap -- flatten into single list
        List<List<Integer>> input3 = List.of(List.of(1,2), List.of(3,4), List.of(5,6));
        List<Integer> outputList = input3.stream().flatMap( n -> n.stream()).toList(); // you can write List::Stream 
        System.out.println(outputList);

        //4. Distinct -- remove duplicates numbers
        List<Integer> input4 = List.of(1,2,2,3,4,5,5,5,4,6);
        List<Integer> output4 = input4.stream().distinct().toList();
        System.out.println(output4);

        //4.2 Distinct -- remove duplicate string
        List<String> input4b = List.of("bob", "bob","alice","alice","serjio");
        List<String> output4b = input4b.stream().distinct().toList();
        System.out.println(output4b);

        //5 Sorted -- natural sort - integer
        List<Integer> input5 = List.of(1,3,6,4,2,8,10,5);
        List<Integer> output5 = input5.stream().sorted().toList();
        System.out.println(output5);

        //5.2 Sorted -- Sort Strings Alphabetically
        List<String> input5b = List.of("bob", "Charlie", "zathura","abby");
        List<String> output5b = input5b.stream().sorted().toList();
        System.out.println(output5b);

        //6 Peek -- debug and print
        List<String> output6 = input5b.stream().peek( n -> System.out.println("processing " + n ))
        .sorted().toList();
        System.out.println(output6);

        //7. Limit -- get the first 3 elements from list
        List<Integer> input7 = List.of(1,2,4,5,7,9,0,10);
        List<Integer> output7 = input7.stream().limit(3).toList();
        System.out.println(output7); 

        //8 Skip -- Skip the first 2 elements from list
        List<Integer> output8 = input7.stream().skip(2).toList();
        System.out.println(output8);

    }
    
}
