import java.util.ArrayList;
import java.util.List;

class CarContainer<T extends Car> {

    private int maxSize;
    private final List<T> cars = new ArrayList<>();


    /**
     * Constructor creating a storage for a specified number of cars
     * @param maxSize is the max number of cars in the container element
     */
    CarContainer(int maxSize){
        this.maxSize = maxSize;
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
    List<T> getCars() {
        return cars;
    }

    /**
     * Adds the car to list in the last place
     * @param c the car that will be added
     * @param current
     */
    void add(T c, Object current){
        if(cars.size() < maxSize && c != current){
            cars.add(c);
        }
    }

    /**
     * Removes the car at the last place of the list
     * @return the car that was removed
     */
    T remove(int internalIndex){
        return cars.remove(internalIndex);
    }
}
