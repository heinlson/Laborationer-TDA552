import Model.Vehicles.*;
import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    private CarModel model;


    CarController(CarModel model){
        this.model = model;
        // TODO Remove the association from view to controller
        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0", this);

        // Potentially add new Constructor whom can take in a JFrame

    }

//    CarController(){
//        this(new CarModel());
//    }


    //methods:


    public CarView getFrame() {
        return frame;
    }

    public CarModel getModel() {
        return model;
    }

    void startTimer(){
        timer.start();
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.updateVehicles(frame.getX(), frame.getY());
        }
    }

    // TODO Flytta nedanstående metoder till model, och refakturera så att
    // TODO koden gör detsamma som just nu (d.v.s ändra i view)

    // Calls the gas method for each car once
    void gas(int amount) {
        double percentage = ((double) amount) / 100;
        for (IVehicle car : model.getCars()) {
            car.gas(percentage);
        }
    }

    // Calls the brake method for each car once
    void brake(int amount) {
        double percentage = ((double) amount) / 100;
        for (IVehicle car : model.getCars()) {
            car.brake(percentage);
        }
    }

    // Turbo on for Saab
    void turboOn(){
        for(IVehicle c : model.getCars()) {
            if (c instanceof Saab95) {
                ((Saab95) c).setTurboOn();
            }
        }
    }

    // Turbo on for Saab
    void turboOff(){
        for(IVehicle c : model.getCars()) {
            if (c instanceof Saab95) {
                ((Saab95) c).setTurboOff();
            }
        }
    }

    /**
     *  Raise flatbed of all Scania cars
     */
    void flatbedUp(){
        for(IVehicle c : model.getCars()) {
            if (c instanceof Scania) {
                ((Scania) c).raiseFlatbed(40);
            }
        }
    }

    /**
     * Lower flatbed of all Scania cars
     */
    void flatbedDown(){
        for(IVehicle c : model.getCars()) {
            if (c instanceof Scania) {
                ((Scania) c).lowerFlatbed(40);
            }
        }
    }

    void startAllEngines() {
        for (IVehicle c : model.getCars()) {
            c.startEngine();
        }
    }

    void stopAllEngines() {
        for (IVehicle c : model.getCars()) {
            c.stopEngine();
        }
    }
}
