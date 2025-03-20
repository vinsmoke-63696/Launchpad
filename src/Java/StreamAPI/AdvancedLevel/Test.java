package Java.StreamAPI.AdvancedLevel;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,null,2,3,4,5,1);
        //second highst

        Optional<Integer> op = Optional.ofNullable(list.stream().distinct().sorted().skip(1).findFirst().orElse(5));
        System.out.println(op);
    }    
}
