package Java.Multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;

public class FileReadSingleThread {

    //Time taken - 1346 miliseconds on 25th December 2024

    public static void main(String[] args) {
        String filePath = "C://Users//Lenovo//Downloads//large_file_with_line_numbers.txt";

        try{
            Instant start = Instant.now();

            StringBuilder content = new StringBuilder();

            try(BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))){
                String line;
                while((line = reader.readLine())!= null){
                    content.append(line).append("\n");
                }
            }

            Instant end = Instant.now();

            long timeElapsed = Duration.between(start, end).toMillis();
            System.out.println("File read succesfully");
            System.out.println("Time taken - " + timeElapsed + " miliseconds");
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
}
