package Model;

import Model.Vehicles.IVehicle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarModel {
    private final Map<IVehicle, BufferedImage> vehicles = new HashMap<>();
    private final List<CarObserver> observers = new ArrayList<>();

    public List<IVehicle> getCars() {
        return new ArrayList<>(vehicles.keySet());
    }

    public Map<IVehicle, BufferedImage> getVehicles() {
        return vehicles;
    }

    /**
     * Add vehicle to hashMap and associate a vehicle with it's corresponding image
     * @param vehicle the vehicle to be bound to an image, most often sent via VehicleFactory
     */
    public void addVehicle(IVehicle vehicle){
        BufferedImage image;
        try {
            image = ImageIO.read(
                    new File("src\\pics\\" + vehicle.getClass().getSimpleName() + ".jpg"));
            vehicles.put(vehicle, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateVehicles(int screenWidth, int screenHeight){

        for (IVehicle v : vehicles.keySet()){
            v.move();
            checkEdgeCollision(v, screenWidth, screenHeight);
        }
        updateObservers();

    }

    /**
     * Check if vehicle is outside of the bounds of the window, reverse it if so-
     * @param vehicle the vehicle in question
     */
    private void checkEdgeCollision(IVehicle vehicle, int width, int height){
        if (vehicle.getX() < 0 || vehicle.getX() > width ||
                vehicle.getY() < 0 || vehicle.getY() > height) {
            vehicle.turnRight();
            vehicle.turnRight();
        }
    }


    public void addObserver(CarObserver item){
        observers.add(item);
    }

    public void updateObservers(){
        for (CarObserver c : observers){
            c.actOnModelChange();
        }
    }




}
