package Java.Multithreading;

public class Hello {

    public static void main(String[] args) {
        new Thread(new World()).start();

        System.out.println("Hello");
    }
    
}
