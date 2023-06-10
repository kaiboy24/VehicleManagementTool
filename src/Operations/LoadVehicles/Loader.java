package Operations.LoadVehicles;

import Vehicles.VehicleProperties.VehicleType;
import Vehicles.Vehicle;

import java.util.HashMap;

public interface Loader {
    public void load(HashMap<Vehicle, Vehicle> vehicles, String source, VehicleType vehicleType);

    void load(VehicleType vehicleType);
}
