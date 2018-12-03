package Vehicles;

/**
 * Interface for an object that can be moved and rotated
 */
public interface IVehicle {
    void move();
    void turnLeft();
    void turnRight();


    int getX();
    int getY();

//    void setX(double x);
//    void setY(double y);
}
