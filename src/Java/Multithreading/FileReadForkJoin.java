package Java.Multithreading;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FileReadForkJoin {

    /* Steps -
     * Divide the File:
         -Calculate the chunk size (e.g., divide the file into 10 MB chunks).
         -Determine byte offsets for each chunk.

     * Fork/Join Framework:
         -Use RecursiveTask to handle each chunk.
         -Read the file in parallel by seeking to specific byte offsets using RandomAccessFile.

     * Merge Results:
         -Combine all chunks into a single result if needed (e.g., for further processing).
     */

    public static void main(String[] args) {

        //Time taken - 816 miliseconds - On 25th Dec 2024

        String filePath = "C://Users//Lenovo//Downloads//large_file_with_line_numbers.txt";

        try{
            //get file size
            Path path = Paths.get(filePath);
            long fileSize = Files.size(path);
            
            //define chunk size - 10Mb per thread
            long chunkSize = 10 * 1024 * 1024; //10 MB 

            //fork join pool 
            ForkJoinPool pool = new ForkJoinPool();
            FileReadTask task = new FileReadTask(filePath, 0, fileSize, chunkSize);

            //Measure the start time
            long start = System.currentTimeMillis();

            //start reading the file in parallel
            String result = pool.invoke(task);

            //Measure the end time
            long end = System.currentTimeMillis();

            System.out.println("Time take - " + (end - start) + " miliseconds");
        } catch(IOException e){
            System.out.println(e);
        }
    }
    
}

// RecursiveTask for reading a file chunk
class FileReadTask extends RecursiveTask<String>{

    private final String filePath;
    private final long start;
    private final long end;
    private final long chunkSize;

    public FileReadTask(String filePath, long start, long end, long chunkSize) {
        this.filePath = filePath;
        this.start = start;
        this.end = end;
        this.chunkSize = chunkSize;
    }

    @Override
    protected String compute() {

        try{
            //If the chunk size is small enough, read it directly
            if((end - start) <= chunkSize){
                return readFileChunk();
            }
            else{
                //Split the task into smaller chunk
                long mid = start + (end - start) / 2;
                FileReadTask leftTask = new FileReadTask(filePath, start, mid, chunkSize);
                FileReadTask rightTask = new FileReadTask(filePath, mid, end, chunkSize);
                System.out.println("Left task - start " + start + " - mid " + mid);
                System.out.println("Right task - mid " + mid + " - end " + end);
                System.out.println("Next iteration");
                //fork the substasks
                leftTask.fork();
                String rightResult = rightTask.compute();
                String leftResult = leftTask.join();

                //Combine result 
                return leftResult + rightResult;
            }
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
        

    }

    private String readFileChunk() throws IOException{
        StringBuilder content = new StringBuilder();
        try(RandomAccessFile file = new RandomAccessFile(filePath, "r")){
            byte[] buffer = new byte[(int) (end - start)];
            file.seek(start);  //move to start position
            file.read(buffer); //read the chunk
            content.append(new String(buffer));
        }

        return content.toString();
    }

}
