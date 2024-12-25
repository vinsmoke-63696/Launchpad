package Java.Multithreading;

public class threads {

    Runnable task = () -> {
        System.out.println(Thread.currentThread().getName() + " Is starting");
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " Was Interrupted");
        }
        System.out.println(Thread.currentThread().getName() + " Has completed execution");
    };

    public static void main(String[] args) {
        threads instance = new threads();
        Thread t1 = new Thread(instance.task);
        t1.start();

        Thread t2 = new Thread(instance.task);
        t2.start();

        try{
            t1.join(); //Main thread will wait for t1 to finish
            System.out.println("T1 is completed, Main continues...");
            t2.join(); //Main thread will wait for t2 to finish
            System.out.println("T2 is completed, Main continues");
        }
        catch(InterruptedException e){
            System.out.println("Main inturrpted");
        }
        System.out.println("Main is complete now");
        System.out.println("Explanation - Here, main will always wait until t1 and t2 finished first.");
    }
    
}
