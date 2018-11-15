import java.util.Stack;

public class CarContainer {

    private int maxSize;
    private final Stack<Car> cars = new Stack<>();


    /**
     * Constructor creating a storage for a specified number of cars
     * @param maxSize is the max number of cars in the container element
     */
    public CarContainer(int maxSize){
        this.maxSize = maxSize;
    }

    /**
     * @return the number of cars in the container
     */
    public int size(){
        return cars.size();
    }

    /**
     * @return the max number of cars for the object
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * @return a "list" containing the cars in the container
     */
    public Stack<Car> getCars() {
        return cars;
    }

    /**
     * Adds the car to list in the last place
     * @param c the car that will be added
     */
    public void push(Car c){
        cars.push(c);
    }

    /**
     * Removes the car at the last place of the list
     * @return the car that was removed
     */
    public Car pop(){
        return cars.pop();
    }
}
