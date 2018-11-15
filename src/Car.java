import java.awt.*;

/**
 * An abstract class for cars
 * Contains a variables for doors, color, speed, engine power, rotation, and x- and y-position
 * Has methods to create, turn, move, accelerate, brake, and get/set some of the instance variables
 */
    public abstract class Car implements IMovable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double direction;
    private double x;
    private double y;




    protected Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
    }

    /**
     * Gets number of doors
     * @return number of doors
     */
    public int getNrDoors(){
        return nrDoors;
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

    /**
     * Gets the direction/rotation of the car, in radians.
     * @return the rotation
     */
    public double getDirection() {
        return direction;
    }

    abstract double speedFactor();

    private void incrementSpeed(double amount){
        currentSpeed = minMax(getCurrentSpeed() + speedFactor() * amount, 0, getEnginePower());
    }

    private void decrementSpeed(double amount){
        currentSpeed = minMax(getCurrentSpeed() - speedFactor() * amount, 0, getEnginePower());
    }

    /**
     * Increases speed by 0-100% of the speed factor
     * @param amount a value that gets mapped between 0 and 1 using the sigmoid function
     */
    public void gas(double amount){
        incrementSpeed(minMax(amount, 0, 1));
    }

    /**
     * Decreases speed by 0-100% of the speed factor
     * @param amount a value that gets mapped between 0 and 1 using the sigmoid function
     */
    public void brake(double amount){
        decrementSpeed(minMax(amount, 0, 1));
    }

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


    // private double sigmoid(double x) {
    //    return 1 / (1 + Math.exp(-x));
    // }
}
