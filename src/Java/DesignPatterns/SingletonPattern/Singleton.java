package Java.DesignPatterns.SingletonPattern;

//idea is to restrict object creation using private constructor and to allow only one object creation
//create a static method that returns object creation for you.

public class Singleton {

    private static Singleton singleObject;
    public int value = 0;

    //create a private constructor to restric object creation
    private Singleton(){};

    //public static method that returns singleton object
    public static Singleton createSingletonObeject(){
        
        if(singleObject != null){
            System.out.println("Singleton object already present, not creating new one");
            return singleObject;
        }

        System.out.println("Singleton object not present, creating new one");
        singleObject = new Singleton();
        return singleObject;

    }

    public int getValue(){
        return value;
    }  
    public void setValue(int value){
        this.value = value;
    }  
}
