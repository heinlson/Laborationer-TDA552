import Vehicles.Car;
import Vehicles.Vehicle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private final Map<Vehicle, BufferedImage> drawObjects = new HashMap<>();


    void mapIt(Car car){

        try {
            if (!drawObjects.containsKey(car)) {
                BufferedImage image = ImageIO.read(
                        new File("src\\pics\\" + car.getClass().getSimpleName() + ".jpg"));
                drawObjects.put(car, image);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block

        // You can remove the "src\\pics" part if running outside of IntelliJ and
        // everything is in the same main folder.
        // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
        // if you are starting in IntelliJ.
        // Linux users need to modify \ to / in path string




    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Vehicle v : drawObjects.keySet()){
            // For every vehicle object
            BufferedImage image = drawObjects.get(v);
            g.drawImage(image, v.getX(), v.getY(), null);
        }
    }
}