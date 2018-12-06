import Vehicles.IVehicle;
import Vehicles.VehicleFactory;

public abstract class CarApp {
    // Abstract, I dunno. Obviously, one should't instantiate this class.
    public static void main(String[] args) {
        CarController cc = new CarController();
        cc.model = new CarModel();

        // Cars must be added this way or they won't show up in view
        cc.model.addCar(VehicleFactory.makeVolvo());

        IVehicle saab = VehicleFactory.makeSaab();
        saab.pointMove(0, 100);
        cc.model.addCar(saab);

        IVehicle scania = VehicleFactory.makeScania();
        scania.pointMove(0, 200);
        cc.model.addCar(scania);

        // TODO Remove the association from view to controller
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.startTimer();
    }
}
