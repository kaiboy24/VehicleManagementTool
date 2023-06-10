package GUI.VehicleButtons;

import Vehicles.VehicleProperties.VehicleType;

import javax.swing.*;

public class VehicleButtonsFactory {
    public static JPanel getPanel(VehicleType vehicleType){
        switch (vehicleType){
            case Car:
                return new CarButtons().getPanel();
            case Motorcycle:
                return new MotorcycleButtons().getPanel();
            default:
                return null;
        }
    }
}
