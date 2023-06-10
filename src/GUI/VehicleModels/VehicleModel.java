package GUI.VehicleModels;

import VehicleBook.VehicleBook;
import Vehicles.VehicleProperties.VehicleType;

import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.stream.Stream;

public abstract class VehicleModel extends DefaultTableModel {
    protected static final String[] commonColumnNames = new String[]{
            "Brand", "Model", "Construction of year", "Mileage", "Condition", "Fuel kind"
    };

    protected VehicleModel(String[] specificColumnNames, VehicleType vehicleType){
        super(VehicleBook.getVehiclesAs2DArray(vehicleType.getMap()), (String[]) Stream.concat(Stream.of(commonColumnNames),
                Stream.of(specificColumnNames)).toArray(v -> new String[v]));
    }
}
