import java.awt.*;

public class Truck extends Car {
    private double flatbedAngle;

    protected Truck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    /**
     * Gets the angle of the flatbed (in degrees)
     * @return the degrees of the angle
     */
    public double getFlatbedAngle() {
        return flatbedAngle;
    }

    protected void setFlatbedAngle(double flatbedAngle) {
        this.flatbedAngle = flatbedAngle;
    }

    double speedFactor() {
        return 0;
    }

    /**
     *  {@inheritDoc}
     *  Furthermore, does not move if flatbed is raised.
     */
    @Override
    public void move(){
        if(flatbedAngle == 0){
            super.move();
        }
    }

    /**
     * Raises the flatbed by amount
     * @param amount number of degrees to raise the flatbed
     */
    public void raiseFlatbed(double amount){
        if(amount + flatbedAngle <= 70 && amount > 0 && getCurrentSpeed() == 0){
            flatbedAngle += amount;
        }
    }

    /**
     * Lowers the flatbed by amount
     * @param amount number of degrees to lower the flatbed
     */
    public void lowerFlatbed(double amount){
        if(flatbedAngle - amount >= 0 && amount > 0){
            flatbedAngle -= amount;
        }
    }
}
