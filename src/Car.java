import java.awt.*;

/**
 * An abstract class for cars
 * Contains a variables for doors, color, speed, engine power, rotation, and x- and y-position
 * Has methods to create, turn, move, accelerate, brake, and get/set some of the instance variables
 */
    public abstract class Car extends Vehicle {
    private int nrDoors; // Number of doors on the car



    protected Car(int nrDoors, double enginePower, Color color, String modelName) {
        super(enginePower, color, modelName);
        this.nrDoors = nrDoors;
    }

    /**
     * Gets number of doors
     * @return number of doors
     */
    public int getNrDoors(){
        return nrDoors;
    }





    abstract double speedFactor();

    private void incrementSpeed(double amount){
        setCurrentSpeed(minMax(getCurrentSpeed() + speedFactor() * amount, 0, getEnginePower()));
    }

    private void decrementSpeed(double amount){
        setCurrentSpeed(minMax(getCurrentSpeed() - speedFactor() * amount, 0, getEnginePower()));
    }

    /**
     * Increases speed by 0-100% of the speed factor
     * @param amount a value that gets mapped between 0 and 1
     */
    public void gas(double amount){
        incrementSpeed(minMax(amount, 0, 1));
    }

    /**
     * Decreases speed by 0-100% of the speed factor
     * @param amount a value that gets mapped between 0 and 1
     */
    public void brake(double amount){
        decrementSpeed(minMax(amount, 0, 1));
    }

    /**
     * Increases/decreases the x- and y-position according to the current speed and rotation
     */


    /**
     * Floors values of x larger than max and ciels (increases) values of x smaller than min.
     * @param x evaluated parameter, possible returned floored or cieled.
     * @param min minimum value of x.
     * @param max maximum value of x.
     * @return Either x, min or max. Depending on value of x.
     */
    private double minMax(double x, double min, double max) {
        return Math.max(Math.min(max, x), min);
    }


    // private double sigmoid(double x) {
    //    return 1 / (1 + Math.exp(-x));
    // }
}
