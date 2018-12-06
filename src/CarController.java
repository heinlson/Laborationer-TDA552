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
    CarView frame;
    CarModel model;


    //methods:
    void startTimer(){
        timer.start();
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (IVehicle car : model.getCars()) {
                car.move();
                checkEdgeCollision(car);
            }
            frame.drawPanel.repaint();
        }
    }

    /**
     * Check if car is outside of the bounds of the window, reverse it if so-
     * @param car the car in question
     */
    private void checkEdgeCollision(IVehicle car){
        if (car.getX() < 0 || car.getX() > CarView.X() ||
            car.getY() < 0 || car.getY() > CarView.Y()) {
            car.turnRight();
            car.turnRight();
        }
    }

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
