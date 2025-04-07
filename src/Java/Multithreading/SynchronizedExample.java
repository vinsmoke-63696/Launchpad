package Java.Multithreading;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class SynchronizedExample{

    int balance = 100;

    public int getBalance(){
        return balance;
    }

    private final Lock lock = new ReentrantLock();
    
    public void withdraw(int amount){

        if(amount <= balance){
            try{
                if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                    if(balance >= amount){
                        System.out.println(Thread.currentThread().getName() + " withdrawing amount - " + amount);

                        try{
                            Thread.sleep(3000);
                            balance -= amount;
                            System.out.println(Thread.currentThread().getName() + " Completed withdrawal");
                        } catch(Exception e){
                            System.out.println(e);
                            Thread.currentThread().interrupt();
                        }
                        finally{
                            lock.unlock();
                        }
                        
                    }else{
                        System.out.println(Thread.currentThread().getName() + " Insufficient balance");
                    }
                }
                else{
                    System.out.println(Thread.currentThread().getName() + " Could not acquire lock, will try again");
                }

            } catch (Exception e){
                System.out.println(e);
                Thread.currentThread().interrupt();
            }
 
        }else{
            System.out.println("Insufficient balance");
        }

    }


}