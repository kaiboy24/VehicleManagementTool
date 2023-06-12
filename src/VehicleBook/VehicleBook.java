package VehicleBook;

import Operations.Load;
import Vehicles.Vehicle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class VehicleBook {
    private static VehicleBook instance = new VehicleBook();
    public static HashMap<Vehicle, Vehicle> Cars;
    public static HashMap<Vehicle, Vehicle> Motorcycles;

    private VehicleBook(){
        Cars = new HashMap<>();
        Motorcycles = new HashMap<>();
        Load.load();
    }

    public static String[][] getVehiclesAs2DArray(HashMap<Vehicle, Vehicle> vehicle){ //returns 2D-Array from a hashmap
        // for their corresponding table
        List<String[]> tmp = new LinkedList<>();
        vehicle.values().forEach(a -> tmp.add(a.getTable()));
        return tmp.toArray(String[][]::new);
    }
    public static VehicleBook getInstance(){return instance;}
}
