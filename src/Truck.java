import java.awt.*;

public abstract class Truck extends Car {

    private final Flatbed flatbed = new Flatbed();

    public Truck(int nrDoors, double enginePower, Color color, String modelName) {
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


    @Override
    double speedFactor() {
        return getEnginePower() * 0.005;
    }

    /**
     *
     * @return
     */
    public double getFlatbedAngle(){
        return flatbed.getFlatbedAngle();
    }

    /**
     *
     * @return
     */
    public boolean getFlatbedOpen(){
        return flatbed.getFlatbedOpen();
    }


    protected Flatbed getFlatbed(){
        return flatbed;
    }
}






