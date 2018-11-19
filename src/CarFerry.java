import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarFerry extends Vehicle{

    private final List<CarContainer> carFiles = new ArrayList<>();


    public CarFerry(int storageSize, int noOfFiles, double enginePower, Color color, String modelName){
        super(enginePower, color, modelName);


        for(int i = 0; i < noOfFiles; i++){
            carFiles.add(new CarContainer(storageSize));
        }
    }

    /**
     * Removes the First car on the file of the ferry that was specified
     * @return the car that was removed, returns null if removing from a file that does not exist
     */
    public Car removeCarInFile(int file){
        if(file >= 0 && file < carFiles.size()){
            return carFiles.get(file).remove(0);
        }
        return null;

    }

    /**
     * Adds a car to the ferry
     * @param car that will be added
     */
    public void addCar(Car car, int file){
        carFiles.get(file).add(car, this);
    }




}
