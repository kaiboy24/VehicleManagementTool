package Operations;

import VehicleBook.VehicleBook;
import Vehicles.Vehicle;


public class AddVehicle{


    public static void addVehicle(Vehicle vehicle){ //adds vehicle to their corresponding Hashmap
        switch (vehicle.getType()){
            case Car:
                VehicleBook.Cars.put(vehicle, vehicle);
            case Motorcycle:
                VehicleBook.Motorcycles.put(vehicle, vehicle);
        }

    }
}
