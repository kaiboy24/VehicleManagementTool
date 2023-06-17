package Operations.SearchVehicles;

import Vehicles.Vehicle;

import java.util.HashMap;
import java.util.List;

public interface Searcher {
    public List<Vehicle> search(HashMap<String, String> searchKeys, HashMap<Vehicle, Vehicle> vehicles);
}
