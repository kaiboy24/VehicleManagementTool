package Vehicles;


import Vehicles.VehicleProperties.VehicleType;

import java.util.HashMap;


public class VehicleFactory {

    public static Vehicle newVehicle(VehicleType vehicleType, String[] vehicleInformation){
        HashMap<String, String> currentVehicle = generateVehicleMap(vehicleType, vehicleInformation);
        switch (vehicleType){
            case Car:
                return new Car(currentVehicle);
            case Motorcycle:
                return new Motorcycle(currentVehicle);
            default:
                return null;
        }
    }

    public static HashMap<String, String> generateVehicleMap(VehicleType vehicleType, String[] vehicleInformation){
        String[] vehiclePropertyNames = new String[0];
        HashMap<String, String> currentVehicle = new HashMap<>();
        if(vehicleType == VehicleType.Car){
            vehiclePropertyNames = Car.carPropertyNames;
        } else if (vehicleType == VehicleType.Motorcycle) {
            vehiclePropertyNames = Motorcycle.motorcyclePropertyNames;
        }
        for(int i = 0; i < vehiclePropertyNames.length; i++){
            currentVehicle.put(vehiclePropertyNames[i], vehicleInformation[i]);
        }
        return currentVehicle;
    }
}
