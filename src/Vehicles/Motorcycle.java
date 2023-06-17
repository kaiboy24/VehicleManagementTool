package Vehicles;

import Vehicles.VehicleProperties.VehicleType;

import java.util.HashMap;

public class Motorcycle extends Vehicle {
    private String[] motorInformation;
    private String[] table;
    final static String[] motorcyclePropertyNames = new String[]{"Brand", "Model", "Construction of year", "Mileage",
            "Condition", "Fuel kind", "Luggage rack", "Pillion seat", "Motorcycle type"};
    public HashMap<String, String> motorcycleInformation;

    /*String[] inputVehicle = {String brand, String model, String constructionOfYear, String mileage,
     String condition, String fuelKind, String luggageRack, String pillionSeat, String motorcycleType}*/
    protected Motorcycle(HashMap<String, String> motorcycleInformation){
        super(motorcycleInformation, motorcyclePropertyNames);
        this.motorcycleInformation = motorcycleInformation;
    }


    @Override
    public String[] getInformationAsArray() {
        String[] arr = new String[motorcyclePropertyNames.length];
        for(int i = 0; i < motorcyclePropertyNames.length; i++){
            arr[i] = motorcycleInformation.get(motorcyclePropertyNames[i]);
        }
        return arr;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.Motorcycle;
    }

}
