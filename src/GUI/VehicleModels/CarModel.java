package GUI.VehicleModels;

import Vehicles.VehicleProperties.VehicleType;

import javax.swing.table.DefaultTableModel;

public class CarModel extends VehicleModel{
    private static DefaultTableModel model = new CarModel();

    private CarModel(){
        super(new String[]{"Cargo space", "Heated seats", "Amount of Seats", "Car type"}, VehicleType.Car);
    }

    public static DefaultTableModel getModelInstance() {
        return model;
    }
}
