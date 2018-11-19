import java.awt.*;

public abstract class Vehicle implements IMovable {

    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private String modelName; // The car model name
    private Color color; // Color of the car
    private double direction;
    private double x;
    private double y;


    protected Vehicle(double enginePower, Color color, String modelName){
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
    }


    /**
     * Gets engine power
     * @return engine power
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Gets current speed
     * @return current speed
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    protected void setCurrentSpeed(double currentSpeed){
        this.currentSpeed = currentSpeed;
    }

    protected void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    protected void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * Gets color of car
     * @return color of car
     */
    public Color getColor(){
        return color;
    }

    /**
     * Gives the car a new paint job
     * @param clr the new color of the car
     */
    protected void setColor(Color clr){
        color = clr;
    }

    /**
     * Gets the direction/rotation of the car, in radians.
     * @return the rotation
     */
    public double getDirection() {
        return direction;
    }

    /**
     * Sets the current speed to something greater that 0
     */
    protected void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Sets the current speed to 0
     */
    protected void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Gets the x coordinate of the car
     * @return the x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y coordinate of the car
     * @return the y coordinate
     */
    public double getY() {
        return y;
    }


    protected void setX(double x) {
        this.x = x;
    }

    protected void setY(double y) {
        this.y = y;
    }

    public void move() {
        x += Math.cos(direction) * getCurrentSpeed();
        y += Math.sin(direction) * getCurrentSpeed();
    }

    /**
     * Changes the rotation of the car, shifts to the left
     */
    public void turnLeft() {
        direction -= Math.PI / 2;
        direction %= (2 * Math.PI);
        if (direction < 0) {
            direction += 2 * Math.PI;
        }
    }

    /**
     * Changes the rotation of the car, shifts to the right.
     */
    public void turnRight() {
        direction += Math.PI / 2;
        direction %= (2 * Math.PI);
    }
}
