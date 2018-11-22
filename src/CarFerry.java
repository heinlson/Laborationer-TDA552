import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarFerry extends Vehicle{

    private final List<CarContainer<Car>> carFiles = new ArrayList<>();


    /**
     * A ferry that can carry cars, has multiple files to store cars in
     * @param storageSize the maximum number of cars in each file
     * @param noOfFiles the number of car files on the Ferry
     * @param modelName the model of the Ferry
     */
    public CarFerry(int storageSize, int noOfFiles, String modelName){
        super(225, Color.orange, modelName);


        for(int i = 0; i < noOfFiles; i++){
            carFiles.add(new CarContainer<>(storageSize));
        }
    }

    @Override
    double speedFactor(){
        return getEnginePower() * 0.01;
    }

    /**
     * Removes the First car on the file of the ferry that was specified
     * @return the car that was removed, throws a IndexOutOfBoundsException if removing from a file that does not exist
     * @param file the file where a car should be removed from (first in - first out)
     */
    public Car removeCarInFile(int file){
        if(file >= 0 && file < carFiles.size()){
            return carFiles.get(file).remove(0);
        }
        throw new IndexOutOfBoundsException("File does not exist, cannot remove car");

    }

    /**
     * Adds a car to the ferry
     * @param car that will be added
     * @param file the file a car should be added to
     */
    public void addCar(Car car, int file){
        if(file >= 0 && file < carFiles.size()){
            carFiles.get(file).add(car, this);
        }
    }




}
