package Java.Multithreading;

public class BankAccount {

    public static void main(String[] args) {
        SynchronizedExample se = new SynchronizedExample();  
    
        Runnable task = new Runnable() {    
    
            public void run() {
                se.withdraw(50);          
        };
    };

    Thread t1 = new Thread(task);
    Thread t2 = new Thread(task);
    t1.start();
    t2.start();

    }

    
}
