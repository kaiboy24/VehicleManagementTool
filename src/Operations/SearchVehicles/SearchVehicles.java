package Operations.SearchVehicles;

import Vehicles.Vehicle;

import javax.swing.*;
import java.util.*;

public class SearchVehicles implements Searcher {
    public SearchVehicles() {
    }

    private List<Vehicle> searchVehicles(String[] searchKeys, HashMap<Vehicle, Vehicle> vehicles) {
        List<Vehicle> currentVehicles = new LinkedList<>(vehicles.values());
        int size = currentVehicles.get(0).getInformationAsArray().length;
        String[] currentVehicle;
        List<Vehicle> searchResults = new LinkedList<>();
        for(Vehicle vehicle: currentVehicles) {
            currentVehicle = vehicle.getInformationAsArray();
            for (int i = 0; i < size; i++) {
                if(!searchKeys[i].isEmpty() && !currentVehicle[i].equals(searchKeys[i])){
                    break;
                }
                else if (i == size - 1) {
                    searchResults.add(vehicle);
                }
            }

        }
        if (searchResults.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Car(s) not found",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return searchResults;
    }

    @Override
    public List<Vehicle> search(String[] searchKeys, HashMap<Vehicle, Vehicle> vehicles) {
        return searchVehicles(searchKeys, vehicles);
    }
}
