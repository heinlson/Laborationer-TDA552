package Vehicles;

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

















    // private double sigmoid(double x) {
    //    return 1 / (1 + Math.exp(-x));
    // }
}
