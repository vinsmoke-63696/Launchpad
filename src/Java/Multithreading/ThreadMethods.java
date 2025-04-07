package Java.Multithreading;

// Methods -> 

// sleep, run, start, interrupt (interrupts given state of thread), 
// yeild (hints scheduler that current thread is willing to yeild its current use of processor. scheduler is free to ignore this hint )
// setDaemon (background thread -> JVM does not wait for completion of the daemon thread )

public class ThreadMethods extends Thread {

    @Override
    public synchronized void run(){
        try {
            Thread.sleep(3000);
            System.out.println("La la Thread");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
    
        ThreadMethods tm = new ThreadMethods();
        tm.start();
        tm.join();
        System.out.println("Main thread");

    }
    
}
