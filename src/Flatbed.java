public class Flatbed {

    private double flatbedAngle;
    private boolean flatbedOpen = false;


    /**
     * Gets the angle of the flatbed (in degrees)
     * @return the degrees of the angle
     */
    public double getFlatbedAngle() {
        return flatbedAngle;
    }

    /**
     * Gets whether or not the flatbed is open
     * @return the openness of the flatbed
     */
    public boolean getFlatbedOpen() {
        return flatbedOpen;
    }


    /**
     * Raises the flatbed by amount, to a maximum
     * @param amount number of degrees to raise the flatbed
     */
    public void raiseFlatbed(double amount, Car c){
        // Kan bara ändras om inte speed
        if(c.getCurrentSpeed() == 0){
            if(amount + flatbedAngle <= 70 && amount > 0){
                flatbedAngle += amount;
            }
            else if(flatbedAngle + amount >= 70){
                flatbedAngle = 70;
            }
        }

        if(flatbedAngle > 0){
            flatbedOpen = true;
        }

    }


    /**
     * Lowers the flatbed by amount, to a minimum of zero, does not lower if car is not moving
     * @param amount number of degrees to lower the flatbed
     */
    public void lowerFlatbed(double amount, Car c){
        // Kan bara ändras om inte speed
        if(c.getCurrentSpeed() == 0){
            if(flatbedAngle - amount >= 0 && amount > 0){
                flatbedAngle -= amount;
            }
            else if(flatbedAngle - amount <= 0){
                flatbedAngle = 0;
            }
        }

        if(flatbedAngle == 0){
            flatbedOpen = false;
        }

    }

}
