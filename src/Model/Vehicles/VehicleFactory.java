package Model.Vehicles;

public class VehicleFactory {



    public static Volvo240 makeVolvo(){
        return new Volvo240();
    }

    public static Saab95 makeSaab(){
        return new Saab95();
    }

    public static Scania makeScania(){
        return new Scania();
    }

    public static CarTransport makeCarTransport(){
        return new CarTransport(10);
    }

    public static CarTransport makeCarTransport(int maxSize){
        return new CarTransport(maxSize);
    }

    public static CarFerry makeCarFerry(){
        return new CarFerry(10, 3, "Some Arbitrary Ferry");
    }

    public static CarFerry makeCarFerry(int storageSize, int noOfFiles){
        return new CarFerry(storageSize, noOfFiles, "Some Arbitrary Ferry");
    }
}
