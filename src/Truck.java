import java.awt.*;

public abstract class Truck extends Car {

    private final Flatbed flatbed = new Flatbed(this);

    protected Truck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    /**
     *  {@inheritDoc}
     *  Furthermore, a raised flatbed will hinder the Truck from moving.
     */
    @Override
    public void move(){
        if(flatbed.getFlatbedAngle() == 0){
            super.move();
        }
    }


    @Override
    double speedFactor() {
        return getEnginePower() * 0.005;
    }

    /**
     * Gets the current angles of the flatbed of the object
     * @return the angle of the flatbed
     */
    public double getFlatbedAngle(){
        return flatbed.getFlatbedAngle();
    }

    /**
     * Returns whether the flatbed is open (usable) or closed (not useable).
     * @return a boolean of true (open) or false (closed)
     */
    public boolean getFlatbedOpen(){
        return flatbed.getFlatbedOpen();
    }


    protected Flatbed getFlatbed(){
        return flatbed;
    }
}






