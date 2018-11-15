import java.awt.*;
import java.util.Stack;

public class CarTransport extends Car {

    private int maxSize;
    private boolean flatbedOpen = false;
    private Truck truck;

    private final Stack<Car> cars = new Stack<>();

    /**
     * Creates a car transport with the given max number of cars and color
     * @param c the color of the car
     * @param maxSize the max amount of cars in the car transport
     */
    public CarTransport(Color c, int maxSize) {
        super(2, 200, Color.orange, "Car transport");
        truck = new Truck(2, 200, c, "Car transport");
        this.maxSize = maxSize;
    }

    /**
     * Creates a car transport with the given max number of cars
     * @param maxSize the max amount of cars in the car transport
     */
    public CarTransport(int maxSize) {
        this(Color.orange, maxSize);
    }

    /**
     * Adds a car to the transporter if it is not full
     * @param c the car to be added to the flatbed
     */
    public void addCar(Car c) {
        double distance = Math.sqrt(Math.pow(getX() - c.getX(), 2) + Math.pow(getY() - c.getY(), 2));
        if (cars.size() < maxSize && distance <= 2 && flatbedOpen && c != this) {
            cars.push(c);
        }
    }

    /**
     * Removes the last car from the transporter
     */
    public void removeCar() {
        if (flatbedOpen) {
            Car c = cars.pop();
            c.setX(getX() + 2);
            c.setY(getY() + 2);
        }
    }

    /**
     * Gets whether or not the flatbed is open
     * @return the openness of the flatbed
     */
    public boolean getFlatbedOpen() {
        return flatbedOpen;
    }

    @Override
    double speedFactor() {
        return truck.getEnginePower() * 0.005;
    }

    /**
     * Raises the flatbed to a predetermined amount
     */
    public void raiseFlatbed() {
        flatbedOpen = true;
        truck.raiseFlatbed(40);
    }

    /**
     * Lowers the flatbed to where it is closed
     */
    public void lowerFlatbed() {
        flatbedOpen = false;
        truck.lowerFlatbed(40);
    }

    /**
     * {@inheritDoc}
     * Also updates positions of all cars on the transporter
     */
    @Override
    public void move() {
        super.move();
        for (Car c : cars) {
            c.setX(getX());
            c.setY(getY());
        }
    }

}
