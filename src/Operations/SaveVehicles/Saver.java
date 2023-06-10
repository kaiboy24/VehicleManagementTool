package Operations.SaveVehicles;

import Vehicles.Vehicle;

import java.util.HashMap;

public interface Saver {
    public void save(String target, HashMap<Vehicle, Vehicle> vehicles);
}
