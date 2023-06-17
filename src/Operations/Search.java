package Operations;

import Vehicles.VehicleFactory;
import Vehicles.VehicleProperties.VehicleType;
import Operations.SearchVehicles.SearchVehicles;
import Operations.SearchVehicles.Searcher;
import VehicleBook.VehicleBook;
import Vehicles.Vehicle;

import java.util.HashMap;
import java.util.List;

public class Search {
    private static Searcher searchVehicles = new SearchVehicles();

    public static List<Vehicle> search(VehicleType vehicleType, String[] searchKeys){//searches and returns vehicles as a list
        HashMap<String, String> searchKeysMap = VehicleFactory.generateVehicleMap(vehicleType, searchKeys);
        switch (vehicleType){
            case Car:
                return searchVehicles.search(searchKeysMap, VehicleBook.Cars);
            case Motorcycle:
                return searchVehicles.search(searchKeysMap, VehicleBook.Motorcycles);
            default:
                return null;
        }
    }
}
