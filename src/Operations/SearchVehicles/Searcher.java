package Operations.SearchVehicles;

import Vehicles.Vehicle;

import java.util.HashMap;
import java.util.List;

public interface Searcher {
    public List<Vehicle> search(String[] searchKeys, HashMap<Vehicle, Vehicle> vehicles);
}
