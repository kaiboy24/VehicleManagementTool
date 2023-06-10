package Operations;

import Vehicles.VehicleProperties.VehicleType;
import Operations.LoadVehicles.LoadVehicleBook;
import Operations.LoadVehicles.Loader;
import Vehicles.Vehicle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Load {
    private static Loader loadVehicles = new LoadVehicleBook();

    public static void load(){//loads every vehicle's type txt file into their corresponding Hashmap
        Arrays.asList(VehicleType.class.getEnumConstants()).forEach(loadVehicles::load);
    }
    public static void load(HashMap<Vehicle, Vehicle> vehicles, String source, VehicleType vehicleType){
        //Loads only a specific vehicle type from a specific txt file into a specific Hashmap
        loadVehicles.load(vehicles, source, vehicleType);
    }
}
