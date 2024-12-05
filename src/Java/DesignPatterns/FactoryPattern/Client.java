package Java.DesignPatterns.FactoryPattern;

public class Client {

    public static void main(String[] args) {
        ModelFactory modelFactory = new ModelFactory();

        //ModelTesla, ModelBMW
        VehicleInterface tesla = modelFactory.getYourCar("ModelTesla");
        tesla.createModel();

        VehicleInterface bMW = modelFactory.getYourCar("ModelBMW");
        bMW.createModel();
    }
    
}
