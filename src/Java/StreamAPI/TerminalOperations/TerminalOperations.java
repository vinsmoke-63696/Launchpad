package Java.StreamAPI.TerminalOperations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {

    public static void main(String[] args) {
        
    //1 Collect a stream into List
    List<Integer> list = Stream.of(1,2,3,4,5,6,7,8).collect(Collectors.toList());
    System.out.println(list);

    //2. Count -- count numbers greater than 3
    long count = Stream.of(1,2,4,5,6,7,2,8)
                .filter(n -> n > 3) 
                .count();
    System.out.println(count);

    //3. Max  -- find the maximum number
    List<Integer> list2 = List.of(1,2,4,5,8,6,7);
    Optional<Integer> num = list2.stream().max(Integer::compare);
    System.out.println(num.orElse(-1));

    //4 Min -- find the minimum number
    List<Integer> input4 = List.of(3,4,5,6,7,2,8);
    Optional<Integer> output4 = input4.stream().min((a,b) -> Integer.compare(a,b));
    System.out.println(output4.orElse(-1)); 


    //find second highest -- update - code is incorrect
    Optional<Integer> op = input4.stream().sorted(Comparator.reverseOrder()).limit(2).min((a,b) -> Integer.compare(a, b));
    int q = input4.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(op.orElse(-1));
        System.out.println(q);

    //5. ForEach -- print all
    input4.stream().forEach( n -> System.out.print(n + " "));
    input4.stream().forEach(System.out::print);
    System.out.println();

    //6. toArray -- Stream to array
    Integer[] array = List.of(1,2,3,4).stream().toArray(n -> new Integer[n]);
    System.out.println(Arrays.toString(array));

     
    //7. reduce -- find sum of all numbers
    Integer ans = List.of(1,2,3,4).stream().reduce(0, (a,b) -> Integer.sum(a, b));
    System.out.println(ans);

    //7.2 reduce -- find multipliction
    Integer multiply = List.of(1,2,3,4).stream().reduce(1,(a,b) -> a * b);
    System.out.println(multiply);

    //8 findFirst and findAny  -- find any even number
    Optional<Integer> number = List.of(1,2,3,4).stream().filter(n -> n % 2 == 0 ).findAny();
    System.out.println(number.orElse(-1));

    //9 AnyMatch, AllMatch, NoneMatch  -- check if any number is greater than 4
    boolean flag = List.of(2,4,6,8).stream().anyMatch(n -> n > 4 );
    System.out.println(flag);

    }
  
    
}
