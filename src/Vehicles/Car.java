package Vehicles;

import Vehicles.VehicleProperties.VehicleType;
import Vehicles.CarProperties.HeatedSeats;
import Vehicles.CarProperties.CarType;

import java.util.HashMap;

public class Car extends Vehicle {
    private String cargoSpace;
    private HeatedSeats heatedSeats;
    private String amountOfSeats;
    private CarType carType;
    private String[] table;

    private HashMap<String, String> information;
    public HashMap<String, String> carInformation;
    final static String[] carPropertyNames = new String[]{"Brand", "Model", "Construction of year", "Mileage",
            "Condition", "Fuel kind", "Cargo space", "Heated seats", "Amount of seats", "Car type"};

    /*String[] inputVehicle = {String brand, String model, String constructionOfYear, String mileage,
     String condition, String fuelKind, String cargoSpace, String heatedSeats, String amountOfSeats, String carType}*/

    protected Car(HashMap<String, String> carInformation){
        super(carInformation, carPropertyNames);
        this.carInformation = carInformation;
        /* this.heatedSeats = HeatedSeats.valueOf(inputCar[7].replace(" ", "_"));
        this.carType = CarType.valueOf(inputCar[9].replace(" ", "_"));*/

    }

    @Override
    public String[] getInformationAsArray() {
        String[] arr = new String[carPropertyNames.length];
        for(int i = 0; i <carPropertyNames.length; i++){
            arr[i] = carInformation.get(carPropertyNames[i]);
        }
        return arr;
    }


    @Override
    public VehicleType getType() {
        return VehicleType.Car;
    }




}
