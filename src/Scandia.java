import java.awt.*;

public class Scandia extends Truck {

    /**
     * Empty constructor
     */
    public Scandia(){
        this(Color.white);
    }


    /**
     * Creates a Scania with a given color
     * @param c the color of the Scania
     */
    public Scandia(Color c){
        super(2, 150, c, "Scandia");
    }

    @Override
    double speedFactor(){
        return getEnginePower() * 0.005;
    }


}
