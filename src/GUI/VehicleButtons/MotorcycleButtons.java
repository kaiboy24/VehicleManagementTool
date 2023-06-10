package GUI.VehicleButtons;

import GUI.View;
import Vehicles.VehicleProperties.VehicleType;

public class MotorcycleButtons extends VehicleButtons {
    public MotorcycleButtons(){
        super(View.motorcycleTable, VehicleType.Motorcycle, View.motorcycleModel);
    }
}
