package Operations;

import VehicleBook.VehicleBook;
import Vehicles.Car;
import Vehicles.Vehicle;
import Vehicles.VehicleProperties.Brand;
import Vehicles.VehicleProperties.Condition;
import Vehicles.VehicleProperties.FuelKind;

import java.util.Arrays;
import java.util.HashMap;

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
