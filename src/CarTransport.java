import java.awt.*;

public class CarTransport extends Car {


    private boolean flatbedOpen = false;
    private Truck truck;
    private final CarContainer carStorage;


    /**
     * Creates a car transport with the given max number of carStorage and color
     * @param c the color of the car
     * @param maxSize the max amount of carStorage in the car transport
     */
    public CarTransport(Color c, int maxSize) {
        super(2, 200, Color.orange, "Car transport");
        truck = new Truck(2, 200, c, "Car transport");
        carStorage = new CarContainer(maxSize);
    }

    /**
     * Creates a car transport with the given max number of carStorage
     * @param maxSize the max amount of carStorage in the car transport
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
        if (carStorage.size() < carStorage.getMaxSize() && distance <= 2 && flatbedOpen && c != this) {
            carStorage.push(c);
        }
    }

    /**
     * Removes the last car from the transporter
     */
    public void removeCar() {
        if (flatbedOpen) {
            Car c = carStorage.pop();
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
     * Also updates positions of all carStorage on the transporter
     */
    @Override
    public void move() {
        super.move();
        for (Car c : carStorage.getCars()) {
            c.setX(getX());
            c.setY(getY());
        }
    }

}
