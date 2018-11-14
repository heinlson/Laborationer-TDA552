import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    @Test
    void speedFactor() {
        Saab95 s = new Saab95();
        assertEquals(1.25, s.speedFactor());
    }

    @Test
    void isTurboOn(){
        Saab95 s = new Saab95();
        assertFalse(s.isTurboOn());
    }

    @Test
    void turboOn(){
        Saab95 s = new Saab95();
        s.setTurboOn();
        assertTrue(s.isTurboOn());
    }

    @Test
    void turboOff(){
        Saab95 s = new Saab95();
        s.setTurboOff();
        assertFalse(s.isTurboOn());
    }

    @Test
    void gas() {
        Saab95 s = new Saab95();
        s.gas(1);
        assertEquals(1.25, s.getCurrentSpeed());
    }

    @Test
    void brake() {
        Saab95 s = new Saab95();
        s.gas(1);
        s.brake(1);
        assertEquals(0, s.getCurrentSpeed());
    }
}