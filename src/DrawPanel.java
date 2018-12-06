import Vehicles.IVehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private final CarModel model;

    // Initializes the panel and reads the images
    DrawPanel(int x, int y, CarModel model) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);


        // You can remove the "src\\pics" part if running outside of IntelliJ and
        // everything is in the same main folder.
        // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
        // if you are starting in IntelliJ.
        // Linux users need to modify \ to / in path string

        this.model = model;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(IVehicle v : model.getCars()){
            // For every vehicle object
            BufferedImage image = model.getVehicles().get(v);
            g.drawImage(image, v.getX(), v.getY(), null);
        }
    }
}