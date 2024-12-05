package Java.SingletonPattern;

public class TestSingleton {

    public static void main(String[] args) {
        Singleton singleObject = Singleton.createSingletonObeject();
        singleObject.setValue(10);
        System.out.println(singleObject.getValue());

        Singleton anotherSingleObject = Singleton.createSingletonObeject();
        System.out.println(anotherSingleObject.getValue());
    }
    
}
