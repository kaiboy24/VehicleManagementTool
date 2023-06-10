package GUI.VehicleControlling;

import Vehicles.VehicleProperties.VehicleType;

import java.awt.event.ActionEvent;

public class VehicleControlFactory {
    public static void setAction(ActionEvent e, VehicleType vehicleType){
        switch (vehicleType){
            case Car:
                new CarControl().selectAction(e);
            case Motorcycle:
                new MotorcycleControl().selectAction(e);
        }
    }
}
