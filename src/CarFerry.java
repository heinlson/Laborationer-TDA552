import java.awt.*;

public class CarFerry extends Vehicle{

    private final CarContainer carStorage;

    public CarFerry(int storageSize, double enginePower, Color color, String modelName){
        super(enginePower, color, modelName);
        carStorage = new CarContainer(storageSize);
    }

    /**
     * Removes the First car in the ferry
     * @return the car that was removed
     */
    public Car removeCar(){
        return carStorage.remove(0);
    }

    /**
     * Adds a car to the ferry
     * @param car that will be added
     */
    public void addCar(Car car){
        carStorage.add(car, this);
    }




}
