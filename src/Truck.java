import java.awt.*;

public abstract class Truck extends Car {

    private final Flatbed flatbed = new Flatbed();

    protected Truck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }


    /**
     *  {@inheritDoc}
     *  Furthermore, does not move if flatbed is raised.
     */
    @Override
    public void move(){
        if(flatbed.getFlatbedAngle() == 0){
            super.move();
        }
    }


    /**
     *
     * @return
     */
    public boolean getFlatbedOpen(){
        return flatbed.getFlatbedOpen();
    }

    /**
     *
     * @param degrees
     */
    public void raiseFlatbed(double degrees){
        flatbed.raiseFlatbed(degrees, this);
    }

    /**
     *
     * @param degrees
     */
    public void lowerFlatbed(double degrees){
        flatbed.lowerFlatbed(degrees, this);
    }


    /**
     *
     * @return
     */
    public double getFlatbedAngle(){
        return flatbed.getFlatbedAngle();
    }


    protected Flatbed getFlatBed(){
        return flatbed;
}





}
