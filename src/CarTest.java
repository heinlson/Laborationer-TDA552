
import org.junit.jupiter.api.Test;

import java.awt.*;



import static junit.framework.TestCase.assertEquals;

 class CarTest {


    @Test
    void testEmptyCar(){
        Car c = new Volvo240();
        Car saab = new Saab95();

        // Test getters/setters on constructor call,
        assertEquals(4, c.getNrDoors());
        assertEquals(2, saab.getNrDoors());

        assertEquals(125, saab.getEnginePower());

        assertEquals(0, c.getCurrentSpeed());

        assertEquals(Color.black, c.getColor());

        assertEquals(0, c.getX());

        assertEquals(0, c.getY());

        assertEquals(0, c.getDirection());

        c.setColor(Color.red);
        assertEquals(Color.red, c.getColor());

        c.startEngine();
        assertEquals(0.1, c.getCurrentSpeed());

        c.stopEngine();
        assertEquals(0, c.getCurrentSpeed());


    }

//    @Test
//    void speedFactor() {
//        Volvo240 v = new Volvo240();
//        assertEquals(1.25, v.speedFactor());
//    }

//    @Test
//    void gas() {
//        Car c = new Volvo240();
//        c.gas(1);
//        assertEquals(1.25, c.getCurrentSpeed());
//    }

//    @Test
//    void brake() {
//    }

    @Test
    void move() {
        Car c = new Volvo240();
        c.gas(1);
        c.move();
        assertEquals(c.getCurrentSpeed(), c.getX());
    }

    @Test
    void gasTooHigh(){
        Car c = new Volvo240();
        c.gas(20);
        assertEquals(1.25, c.getCurrentSpeed());

    }


    @Test
    void turnLeft() {
        Car c = new Volvo240();
        c.turnLeft();
        assertEquals(3 * Math.PI / 2, c.getDirection());
    }

    @Test
    void turnRight() {
        Car c = new Volvo240();
        c.turnRight();
        assertEquals(Math.PI / 2, c.getDirection());
    }

//    @Test
//    void minMax(){
//        assertEquals( 3, minMax(1, 2, 3));
//    }
}