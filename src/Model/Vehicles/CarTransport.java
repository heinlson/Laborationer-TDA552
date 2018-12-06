package Model.Vehicles;

import java.awt.*;

class CarTransport extends Truck {


    private final CarContainer carStorage;

    /**
     * Creates a car transport with the given max number of carStorage and color
     * @param c the color of the car
     * @param maxSize the max amount of carStorage in the car transport
     */
    CarTransport(Color c, int maxSize) {
        super(2, 200, c, "Car transport");
        carStorage = new CarContainer(maxSize, this);
    }

    /**
     * Creates a car transport with the given max number of carStorage
     * @param maxSize the max amount of carStorage in the car transport
     */
    CarTransport(int maxSize) {
        this(Color.orange, maxSize);
    }

    /**
     * Adds a car to the transporter if it is not full
     * @param car the car to be added to the flatbed
     */
    public void addCar(Car car) {
        double distance = Math.sqrt(Math.pow(getX() - car.getX(), 2) + Math.pow(getY() - car.getY(), 2));
        if (distance <= 2 && getFlatbedOpen()) {
            carStorage.add(car);
        }
    }

    /**
     * Removes the Last car from the transporter
     * @return the car that was removed, throws NullPointerException if flatbed is closed
     */
    public Car removeCar() {
        if (getFlatbedOpen()) {
            return carStorage.removeLast();
        }
        throw new NullPointerException("Flatbed is closed, cannot remove car");
    }

    /**
     * Get the max number of cars that can be stored in the car transport
     * @return the max number of cars
     */
    public int getMaxSize(){
        return carStorage.getMaxSize();
    }


    /**
     * If car is not moving, raises the flatbed to where it is open, returns flatbed state
     */
    public void raiseFlatbed() {
        getFlatbed().raiseFlatbed(40);
    }

    /**
     * If car is not moving, lowers the flatbed to where it is closed, returns flatbed state
     */
    public void lowerFlatbed() {
        getFlatbed().lowerFlatbed(40);

    }

    /**
     * {@inheritDoc}
     * Also updates positions of all carStorage on the transporter
     */
    @Override
    public void move() {
        super.move();
        carStorage.updatePosition();
    }



}
