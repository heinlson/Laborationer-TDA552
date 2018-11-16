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


    public void raiseFlatbed(double degrees){
        getFlatbed().raiseFlatbed(degrees, this);
    }

    /**
     *
     * @param degrees
     */
    public void lowerFlatbed(double degrees){
        getFlatbed().lowerFlatbed(degrees, this);
    }









}
