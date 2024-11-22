package Java;

import java.util.concurrent.*;

public class ThreadsCallable {

    //Callable returns a result and can throw checked exceptions
    Callable<String> task = () -> {
        return "I am a task inside callable";
    };

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ThreadsCallable tc = new ThreadsCallable();
                
        Future<String> resultObject = executorService.submit(tc.task); 
        System.out.println(resultObject.get());
        executorService.shutdown();

    }
    
}
