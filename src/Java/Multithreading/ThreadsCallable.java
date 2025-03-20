package Java.Multithreading;

import java.util.concurrent.*;

public class ThreadsCallable {

    //Callable returns a result and can throw checked exceptions
    Callable<Integer> task = () -> {
        return 20;
    };

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ThreadsCallable tc = new ThreadsCallable();
                
        Future<Integer> resultObject = executorService.submit(tc.task); 
        System.out.println(resultObject.get());
        executorService.shutdown();

    }
    
}
