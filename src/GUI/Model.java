package GUI;

import GUI.VehicleModels.VehicleModelFactory;
import VehicleBook.VehicleBook;
import Vehicles.Vehicle;
import Vehicles.VehicleProperties.VehicleType;

import javax.swing.table.DefaultTableModel;
import java.util.HashMap;

public class Model {
    public static DefaultTableModel getModel(VehicleType vehicleType){
        return VehicleModelFactory.getModel(vehicleType);
    }

}
