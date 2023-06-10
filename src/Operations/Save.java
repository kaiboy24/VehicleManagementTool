package Operations;

import Vehicles.VehicleProperties.VehicleType;
import Operations.SaveVehicles.SaveVehicles;
import Operations.SaveVehicles.Saver;
import Vehicles.Vehicle;

import java.util.HashMap;

public class Save {
    private static Saver saveVehicles = new SaveVehicles();

    public static void save(VehicleType type){
        saveVehicles.save(type.name() + ".txt", type.getMap());
    }
    public static void save(VehicleType type, HashMap<Vehicle, Vehicle> vehicles){
        saveVehicles.save(type.name() + "_SaveTesting.txt", vehicles);
    }
}

