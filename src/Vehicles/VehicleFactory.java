package Vehicles;

public class VehicleFactory {

    public static CarFerry makeCarFerry(int storageSize, int noOfFiles){
        return new CarFerry(storageSize, noOfFiles, "Some Arbitrary Ferry");
    }

    public static Volvo240 makeVolvo(){
        return new Volvo240();
    }

    public static Saab95 makeSaab(){
        return new Saab95();
    }

    public static Scania makeScania(){
        return new Scania();
    }


}
