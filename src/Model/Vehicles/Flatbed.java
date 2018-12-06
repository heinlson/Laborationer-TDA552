package Model.Vehicles;

class Flatbed extends Storage{


    private double flatbedAngle;
    private boolean flatbedOpen = false;
    //private final IVehicle self;

    /**
     * A flatbed attached to a vehicle, can be raised or lowered
     * @param self the vehicle that has said flatbed
     */
    Flatbed(IVehicle self){
        owner = self;
    }

    /**
     * Gets the angle of the flatbed (in degrees)
     * @return the degrees of the angle
     */
    double getFlatbedAngle() {
        return flatbedAngle;
    }

    /**
     * Gets whether or not the flatbed is open
     * @return the openness of the flatbed
     */
    boolean getFlatbedOpen() {
        return flatbedOpen;
    }


    /**
     * Raises the flatbed by amount, to a maximum
     * @param amount number of degrees to raise the flatbed
     */
    void raiseFlatbed(double amount){
        if(owner.getCurrentSpeed() == 0){
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
    void lowerFlatbed(double amount){
        if(owner.getCurrentSpeed() == 0){
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
