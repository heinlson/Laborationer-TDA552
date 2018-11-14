import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {

    @Test
    void speedFactor() {
        Volvo240 v = new Volvo240();
        assertEquals(1.25, v.speedFactor());
    }

    @Test
    void gas() {
        Volvo240 v = new Volvo240();
        v.gas(1);
        assertEquals(1.25, v.getCurrentSpeed());
    }

    @Test
    void brake() {
        Volvo240 v = new Volvo240();
        v.gas(1);
        v.brake(1);
        assertEquals(0, v.getCurrentSpeed());
    }
}