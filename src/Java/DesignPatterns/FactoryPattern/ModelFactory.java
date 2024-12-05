package Java.FactoryPattern;

public class ModelFactory {

    public VehicleInterface getYourCar(String model){
        if(model == null) return null;

        if(model.equals("ModelTesla")) return new ModelTesla();

        if(model.equals("ModelBMW")) return new ModelBMW();

        return null;

    }

}
