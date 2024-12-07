package Java.Interfaces.DefaultMethod;

public class DefaultImplementation implements DefaultMethod {

    public void someAbstractMethod(){  //you can't use private/protected here -> Cannot reduce the visibility of the inherited method 
        System.out.println("Implemented the abstract method");
    }

    //now you see, I don't have to implement the default methods.
    //however i can still override them.

    public void overrideThisDefaultMethod(){
        System.out.println("After override");
    }

    public void invoke() {
        
        DefaultMethod interfaceReference = new DefaultImplementation();

        interfaceReference.someAbstractMethod(); //invoke implemented abstract method
        interfaceReference.theDefaultMethod();//invoke first default method TheDefaultMethod
        interfaceReference.secondDefaultMethod();//invoke second default method
        interfaceReference.overrideThisDefaultMethod();//invoke overriden method via class
        DefaultMethod.super.overrideThisDefaultMethod(); //invoke original super method

    }

    public static void main(String[] args) {
        DefaultImplementation dm = new DefaultImplementation();
        dm.invoke();
    }
    
}


