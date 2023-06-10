package Operations;

import Vehicles.VehicleProperties.VehicleType;
import Operations.SearchVehicles.SearchVehicles;
import Operations.SearchVehicles.Searcher;
import VehicleBook.VehicleBook;
import Vehicles.Vehicle;

import java.util.List;

public class Search {
    private static Searcher searchVehicles = new SearchVehicles();

    public static List<Vehicle> search(VehicleType type, String[] searchKeys){//searches and returns vehicles as a list
        switch (type){
            case Car:
                return searchVehicles.search(searchKeys, VehicleBook.Cars);
            case Motorcycle:
                return searchVehicles.search(searchKeys, VehicleBook.Motorcycles);
            default:
                return null;
        }
    }
}
