package Model.Vehicles;

public interface IVehicle {
    void move();
    void turnLeft();
    void turnRight();


    int getX();
    int getY();
    double getCurrentSpeed();

    void pointMove(int x, int y);


    void gas(double amount);
    void brake(double amount);

    void startEngine();
    void stopEngine();


}
