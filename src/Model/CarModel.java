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
    public void addCar(IVehicle vehicle){
        BufferedImage image;
        try {
            image = ImageIO.read(
                    new File("src\\pics\\" + vehicle.getClass().getSimpleName() + ".jpg"));
            vehicles.put(vehicle, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
