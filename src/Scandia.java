import java.awt.*;

public class Scandia extends Car {



    private double flatbedAngle;

    /**
     * Empty constructor
     */
    public Scandia(){
        this(Color.white);
    }


    /**
     * Creates a Volvo with a given color
     * @param c the color of the Volvo
     */
    public Scandia(Color c){
        super(2, 150, c, "Scandia");
    }

    @Override
    double speedFactor(){
        return getEnginePower() * 0.005;
    }

    /**
     * Raises the flatbed by amount
     * @param amount number of degrees to raise the flatbed
     */
    public void raiseFlatbed(double amount){
        if(amount + flatbedAngle <= 70 && amount > 0){
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

    /**
     *  {@inheritDoc}
     *  Furthermore, does not move if flatbed is raised.
     */

    @Override
    public void move(){
        if(flatbedAngle == 0){
            setX(getX() + Math.cos(getDirection()) * getCurrentSpeed());
            setY(getY() + Math.sin(getDirection()) * getCurrentSpeed());

        }
    }
}
