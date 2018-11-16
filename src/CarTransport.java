import java.awt.*;

public class CarTransport extends Truck {


    private final CarContainer carStorage;


    /**
     * Creates a car transport with the given max number of carStorage and color
     * @param c the color of the car
     * @param maxSize the max amount of carStorage in the car transport
     */
    public CarTransport(Color c, int maxSize) {
        super(2, 200, c, "Car transport");
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
     * @param car the car to be added to the flatbed
     */
    public void addCar(Car car) {
        double distance = Math.sqrt(Math.pow(getX() - car.getX(), 2) + Math.pow(getY() - car.getY(), 2));
        if (carStorage.size() < carStorage.getMaxSize() && distance <= 2 && getFlatbedOpen() && car != this) {
            carStorage.push(car);
        }
    }

    /**
     * Removes the last car from the transporter
     */
    public Car removeCar() {
        if (getFlatbedOpen()) {
            Car c = carStorage.pop();
            c.setX(getX() + 2);
            c.setY(getY() + 2);
            return c;
        }
        return null;
    }




    /**
     * If car is not moving, raises the flatbed to where it is open, returns flatbed state
     */
    public void raiseFlatbed() {
        getFlatbed().raiseFlatbed(40, this);
    }

    /**
     * If car is not moving, lowers the flatbed to where it is closed, returns flatbed state
     */
    public void lowerFlatbed() {
        getFlatbed().lowerFlatbed(40, this);

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
