package GUI.VehicleModels;

import Vehicles.VehicleProperties.VehicleType;

import javax.swing.table.DefaultTableModel;

public class VehicleModelFactory {
    public static DefaultTableModel getModel(VehicleType vehicleType){
        switch (vehicleType){
            case Car:
                return CarModel.getModelInstance();
            case Motorcycle:
                return MotorcycleModel.getModelInstance();
            default:
                return null;
        }
    }
}
