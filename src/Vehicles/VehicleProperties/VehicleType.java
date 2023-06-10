package Vehicles.VehicleProperties;

import Vehicles.Vehicle;
import VehicleBook.VehicleBook;
import java.util.HashMap;

public enum VehicleType {
    Car, Motorcycle;

    public HashMap<Vehicle, Vehicle> getMap(){
        switch (this){
            case Car:
                return VehicleBook.Cars;
            case Motorcycle:
                return VehicleBook.Motorcycles;
            default:
                return null;
        }
    }
}
