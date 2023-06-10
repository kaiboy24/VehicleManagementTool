package GUI.VehicleModels;

import Vehicles.VehicleProperties.VehicleType;

import javax.swing.table.DefaultTableModel;

public class MotorcycleModel extends VehicleModel {
    private static DefaultTableModel model = new MotorcycleModel();

    private MotorcycleModel(){
        super(new String[]{"Luggage rack", "Pillion seat", "Motorcycle type"}, VehicleType.Motorcycle);
    }

    public static DefaultTableModel getModelInstance() {return model;}
}
