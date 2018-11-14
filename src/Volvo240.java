import java.awt.*;

/**
 * A subclass of Car
 * Contains an internal calculation of its speed factor using a class specific trim factor
 */
public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    /**
     * Empty constructor
     */
    public Volvo240(){
        this(Color.black);
        stopEngine();
    }

    /**
     * Creates a Volvo with a given color
     * @param c the color of the Volvo
     */
    public Volvo240(Color c){
        super(4, 100, c, "Volvo240");
        stopEngine();
    }

    @Override
    double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}