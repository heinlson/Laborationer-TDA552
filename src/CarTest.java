
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {


    private Car c = new Volvo240();

    @Test
    void getNrDoors(){
        assertEquals(4, c.getNrDoors());
    }

    @Test
    void getEnginePower(){
        assertEquals(100.0, c.getEnginePower());
    }

    @Test
    void getCurrentSpeed(){
        assertEquals(0.0, c.getCurrentSpeed());
    }

    @Test
    void getColor(){
        assertEquals(Color.black, c.getColor());
    }

    @Test
    void getX(){
        assertEquals(0.0, c.getX());
    }

    @Test
    void getY(){
        assertEquals(0.0, c.getY());
    }

    @Test
    void getDirection(){
        assertEquals(0.0, c.getDirection());
    }

    @Test
    void setColor(){
        c.setColor(Color.red);
        assertEquals(Color.red, c.getColor());
    }

    @Test
    void startEngine(){
        c.startEngine();
        assertEquals(0.1, c.getCurrentSpeed());
    }

    @Test
    void stopEngine(){
        c.stopEngine();
        assertEquals(0.0, c.getCurrentSpeed());
    }

    @Test
    void setX(){
        c.setX(10);
        assertEquals(10.0, c.getX());
    }

    @Test
    void setY(){
        c.setY(10);
        assertEquals(10.0, c.getY());
    }


    @Test
     void speedFactor() {
         Volvo240 v = new Volvo240();
         assertEquals(1.25, v.speedFactor());

         Saab95 s = new Saab95();
         assertEquals(1.25, s.speedFactor());
     }

     @Test
     void gas() {
         Volvo240 v = new Volvo240();
         v.gas(1);
         assertEquals(1.25, v.getCurrentSpeed());

         Saab95 s = new Saab95();
         s.gas(1);
         assertEquals(1.25, s.getCurrentSpeed());
     }

     @Test
     void brake() {
         Volvo240 v = new Volvo240();
         v.gas(1);
         v.brake(1);
         assertEquals(0.0, v.getCurrentSpeed());
     }


     @Test
     void turbo(){
         Saab95 s = new Saab95();
         assertFalse(s.isTurboOn());

         s.setTurboOn();
         assertTrue(s.isTurboOn());

         s.setTurboOff();
         assertFalse(s.isTurboOn());
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