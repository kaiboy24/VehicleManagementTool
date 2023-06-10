package Operations;

import VehicleBook.VehicleBook;
import Vehicles.Vehicle;

public class Delete {
    public static void deleteVehicle(Vehicle vehicle){ //deletes vehicle from their corresponding Hashmap
        switch (vehicle.getType()){
            case Car:
                VehicleBook.Cars.remove(vehicle);
            case Motorcycle:
                VehicleBook.Motorcycles.remove(vehicle);
        }
    }
}
