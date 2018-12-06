import Model.CarModel;
import Model.Vehicles.IVehicle;
import Model.Vehicles.VehicleFactory;

public abstract class CarApp {
    // Abstract, I dunno. Obviously, one should't instantiate this class.
    public static void main(String[] args) {
        // Model instantiated here for simple adding of objects to app
        CarModel model = new CarModel();
        CarController cc = new CarController(model);


        // Cars must be added this way or they won't show up in view
        model.addVehicle(VehicleFactory.makeVolvo());

        IVehicle saab = VehicleFactory.makeSaab();
        saab.pointMove(0, 100);
        model.addVehicle(saab);

        IVehicle scania = VehicleFactory.makeScania();
        scania.pointMove(0, 200);
        model.addVehicle(scania);


        // Add view to model observers
        model.addObserver(cc.getFrame());
        // Start the timer
        cc.startTimer();
    }
}
