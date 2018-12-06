package Model.Vehicles;

import java.awt.*;

public class Scania extends Truck {


    /**
     * Empty constructor
     */
    Scania(){
        this(Color.white);
    }


    /**
     * Creates a Model.Vehicles.Scania with a given color
     * @param c the color of the Model.Vehicles.Scania
     */
    Scania(Color c){
        super(2, 150, c, "Model.Vehicles.Scania");
    }


    /**
     * Raises the flatbed of the truck by a certain amount of degrees
     * @param degrees that the flatbed will be lowered by
     */
    public void raiseFlatbed(double degrees){
        getFlatbed().raiseFlatbed(degrees);
    }


    /**
     * Lowers the flatbed of the truck by a certain amount of degrees
     * @param degrees that the flatbed will be lowered by
     */
    public void lowerFlatbed(double degrees){
        getFlatbed().lowerFlatbed(degrees);
    }









}
