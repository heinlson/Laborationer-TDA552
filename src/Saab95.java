import java.awt.*;

/**
 * A subclass of Car
 * Contains turbo boolean and an internal calculation of its speed factor used in moving
 */
public class Saab95 extends Car {

    private boolean turboOn;


    /**
     * Empty constructor
     */
    public Saab95() {
        this(Color.red);
        setTurboOff();
        stopEngine();
    }

    /**
     * Creates a Saab with a given color
     * @param c the color of the Saab
     */
    public Saab95(Color c) {
        super(2, 125, c, "Saab95");
        setTurboOff();
        stopEngine();
    }

    /**
     * Gets if turbo is on or off
     * @return true if turbo is on, false if turbo is off
     */
    public boolean isTurboOn() {
        return turboOn;
    }

    /**
     * Enables the turbo of a Saab
     */
    public void setTurboOn(){
        turboOn = true;
    }


    /**
     * Disables the turbo of a Saab
     */
    public void setTurboOff(){
        turboOn = false;
    }

    @Override
    double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }


}