package Operations.SearchVehicles;

import Vehicles.Vehicle;

import javax.swing.*;
import java.util.*;

public class SearchVehicles implements Searcher {
    public SearchVehicles() {
    }

    private List<Vehicle> searchVehicles(HashMap<String, String> searchKeys, HashMap<Vehicle, Vehicle> vehicles) {
        int i;
        List<Vehicle> searchResults = new LinkedList<>();
        for(Map.Entry<Vehicle, Vehicle> vehicleEntry: vehicles.entrySet()){
            i = 0;
            for(Map.Entry<String, String> searchEntry: searchKeys.entrySet()){
                if(!searchEntry.getValue().isEmpty() && !searchEntry.getValue().equals(vehicleEntry.getValue().vehicleInformation.get(searchEntry.getKey()))){
                    break;
                } else if (i == vehicleEntry.getValue().vehicleInformation.size() - 1) {
                    searchResults.add(vehicleEntry.getValue());
                }
                i++;
            }
        }

        if (searchResults.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Car(s) not found",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return searchResults;
    }

    @Override
    public List<Vehicle> search(HashMap<String, String> searchKeys, HashMap<Vehicle, Vehicle> vehicles) {
        return searchVehicles(searchKeys, vehicles);
    }
}
