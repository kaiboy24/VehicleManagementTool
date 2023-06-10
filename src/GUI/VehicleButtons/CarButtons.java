package GUI.VehicleButtons;

import GUI.View;
import Vehicles.VehicleProperties.VehicleType;

public class CarButtons extends VehicleButtons {

    public CarButtons(){
        super(View.carTable, VehicleType.Car, View.carModel);
    }

}
