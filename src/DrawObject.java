import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawObject {




    private BufferedImage image;
    private Point point;


    public DrawObject(BufferedImage image, Point point){
        this.image = image;
        this.point = point;
    }

    public DrawObject(BufferedImage image, int x, int y){
        this(image, new Point(x, y));

    }

    public BufferedImage getImage() {
        return image;
    }

    public Point getPoint() {
        return point;
    }
}
