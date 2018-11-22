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

    private void incrementSpeed(double amount){
        setCurrentSpeed(minMax(getCurrentSpeed() + speedFactor() * amount, 0, getEnginePower()));
    }

    private void decrementSpeed(double amount){
        setCurrentSpeed(minMax(getCurrentSpeed() - speedFactor() * amount, 0, getEnginePower()));
    }

    /**
     * Increases speed by 0-100% of the speed factor
     * @param amount a value that gets mapped between 0 and 1
     */
    public void gas(double amount){
        incrementSpeed(minMax(amount, 0, 1));
    }

    /**
     * Decreases speed by 0-100% of the speed factor
     * @param amount a value that gets mapped between 0 and 1
     */
    public void brake(double amount){
        decrementSpeed(minMax(amount, 0, 1));
    }

    abstract double speedFactor();

    /**
     * Increases/decreases the x- and y-position according to the current speed and rotation
     */
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

    /**
     * Floors values of x larger than max and ciels (increases) values of x smaller than min.
     * @param x evaluated parameter, possible returned floored or cieled.
     * @param min minimum value of x.
     * @param max maximum value of x.
     * @return Either x, min or max. Depending on value of x.
     */
    private double minMax(double x, double min, double max) {
        return Math.max(Math.min(max, x), min);
    }

}
