package Java.StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamPractice {

    //Easy - Given a list of integers, filter out the odd numbers, square the remaining numbers, and collect them into a list.
    public static void main(String[] args) {
        List<Integer> output = List.of(1,2,3,4,5,6)
                                    .stream()
                                    .filter(n -> n % 2 == 0)
                                    .map(n -> n * n)
                                    .toList();
        System.out.println(output);


    //medium -- Given a list of words, group them by their lengths and count how many words belong to each group.
    List<String> input = List.of("hello", "night", "sanji", "set", "map","a");

    Map<Integer, Integer> map = new HashMap<>();
    for(String s : input){
        int length = s.length();

            map.put(length, map.getOrDefault(length, 0)+1);
 
        }
        System.out.println(map);
    
        //now with stream
    Map<Object, Long> map2 = input.stream().collect(Collectors.groupingBy(n -> n.length(), Collectors.counting()));    
        System.out.println(map2);


    //Hard -- Given a list of sentences, split each sentence into words, 
    //        flatten the words into a single list, and find the longest word.
    List<String> sentences = List.of("Hello I am Sunig", "Whatsup my nigga");
    
    List<String> singleList = new ArrayList<>();
    for(String i : sentences){
        String[] words = i.split("\\s+");

        for(String word : words){
            singleList.add(word);
        }
    }
    System.out.println(singleList);
    int maxLength = 0;
    String longestWord = null;
    for(String word : singleList){
        if(word.length() > maxLength){
            maxLength = word.length();
            longestWord = word;
        }
    }
    System.out.println(maxLength + " For word - " + longestWord);

    //now with Stream
    String longestWordByStream = sentences.stream()
                                          .flatMap(n -> Arrays.stream(n.split("\\s+")))
                                          .max(Comparator.comparingInt(n -> n.length()))
                                          .orElse("");
    System.out.println(longestWordByStream);
    }    
    
}
