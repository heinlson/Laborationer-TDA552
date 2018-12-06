package Model.Vehicles;

import java.util.ArrayList;
import java.util.List;

class CarContainer extends Storage{

    private int maxSize;
    private final List<Car> cars = new ArrayList<>();
    //private IVehicle self;


    /**
     * Constructor creating a storage for a specified number of cars
     * @param maxSize is the max number of cars in the container element
     * @param self the vehicle the container is attached to
     */
    CarContainer(int maxSize, Vehicle self){
        this.maxSize = maxSize;
        owner = self;
    }

    /**
     * The total number of cars in the container
     * @return the number of cars in the container
     */
    int size(){
        return cars.size();
    }

    /**
     * The max size of the container
     * @return the max number of cars for the object
     */
    int getMaxSize() {
        return maxSize;
    }

    /**
     * Gets the list containing cars stored in the container
     * @return a "list" containing the cars in the container
     */
    List<Car> getCars() {
        return cars;
    }

    /**
     * Adds the car to list in the last place, updates the position of the car
     * @param c the car that will be added
     */
    void add(Car c){
        if(cars.size() < maxSize && c != owner){
            c.pointMove(owner.getX(), owner.getY());
            cars.add(c);
        }
    }

    /**
     * Removes the car at the last place of the list and moves it 2 meters from the vehicle
     * @return the car that was removed
     */
    private Car remove(int internalIndex){
        Car c = cars.remove(internalIndex);
        c.pointMove(owner.getX() + 2, owner.getY() + 2);
        return c;
    }

    Car removeFirst(){
        return remove(0);
    }

    Car removeLast(){
        return remove(cars.size() - 1);
    }

    void updatePosition(){
        for (Car c : cars) {
            c.pointMove(owner.getX(), owner.getY());
        }
    }
}
