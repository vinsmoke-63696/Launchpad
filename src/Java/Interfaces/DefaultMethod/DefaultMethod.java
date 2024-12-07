package Java.Interfaces.DefaultMethod;

public interface DefaultMethod {

    void someAbstractMethod();

    default void theDefaultMethod(){
        System.out.println("Default from interface");
    }

    default void secondDefaultMethod(){
        System.out.println("Second Default Method");
    }

    default void overrideThisDefaultMethod(){
        System.out.println("Before override");
    }
    
}
