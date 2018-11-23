import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private final List<DrawObject> drawObjects = new ArrayList<>();

    // Just a single image, TODO: Generalize
    private  BufferedImage volvoImage;
    // To keep track of a single cars position
    private Point volvoPoint = new Point();

    // TODO: Make this general for all cars
    void moveIt(int x, int y){
        for(DrawObject p : drawObjects){
            p.getPoint().x = x;
            p.getPoint().y = y;
        }
        // TODO Remove when it works
        volvoPoint.x = x;
        volvoPoint.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string
            volvoImage = ImageIO.read(new File("src\\pics\\Volvo240.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        // TODO Add methods to add objects to drawObjects
        for(DrawObject d : drawObjects){
            g.drawImage(d.getImage(), d.getPoint().x, d.getPoint().y, null);
        }
    }

    // TODO make enumerable with tags to generalize what car is created
    public void createNewVolvo(){
        drawObjects.add(new DrawObject(volvoImage, new Point()));
    }
}