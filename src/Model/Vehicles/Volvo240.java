package Model.Vehicles;

import java.awt.*;

/**
 * A subclass of Model.Vehicles.Car
 * Contains an internal calculation of its speed factor using a class specific trim factor
 */
class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    /**
     * Empty constructor
     */
    Volvo240(){
        this(Color.black);
        stopEngine();
    }

    /**
     * Creates a Volvo with a given color
     * @param c the color of the Volvo
     */
    Volvo240(Color c){
        super(4, 100, c, "Model.Vehicles.Volvo240");
        stopEngine();
    }

    @Override
    double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}