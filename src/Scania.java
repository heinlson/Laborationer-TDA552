import java.awt.*;

public class Scania extends Truck {





    /**
     * Empty constructor
     */
    public Scania(){
        this(Color.white);
    }


    /**
     * Creates a Scania with a given color
     * @param c the color of the Scania
     */
    public Scania(Color c){
        super(2, 150, c, "Scania");
    }

    @Override
    double speedFactor(){
        return getEnginePower() * 0.005;
    }










}
