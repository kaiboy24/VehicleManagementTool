package Vehicles;


import Vehicles.VehicleProperties.VehicleType;

public class VehicleFactory {
    public static Vehicle newVehicle(VehicleType vehicleType, String[] vehicleInformation){
        switch (vehicleType){
            case Car:
                return new Car(vehicleInformation);
            case Motorcycle:
                return new Motorcycle(vehicleInformation);
            default:
                return null;
        }
    }
}
