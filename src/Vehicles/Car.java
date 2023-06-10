package Vehicles;

import Vehicles.VehicleProperties.VehicleType;
import Vehicles.CarProperties.HeatedSeats;
import Vehicles.CarProperties.CarType;

import java.util.Arrays;
import java.util.HashMap;

public class Car extends Vehicle {
    private String cargoSpace;
    private HeatedSeats heatedSeats;
    private String amountOfSeats;
    private CarType carType;

    private String[] carInformation;
    private String[] table;

    private HashMap<String, String> information;

    /*String[] inputVehicle = {String brand, String model, String constructionOfYear, String mileage,
     String condition, String fuelKind, String cargoSpace, String heatedSeats, String amountOfSeats, String carType}*/

    protected Car(String[] inputCar){
        super(Arrays.copyOfRange(inputCar, 0,6));
        this.table = Arrays.copyOf(inputCar,11);
        this.carInformation = inputCar;
        this.cargoSpace = inputCar[6];
        this.heatedSeats = HeatedSeats.valueOf(inputCar[7].replace(" ", "_"));
        this.amountOfSeats = inputCar[8];
        this.carType = CarType.valueOf(inputCar[9].replace(" ", "_"));

    }

    @Override
    public String[] getTable() {
        return table;
    }


    @Override
    public VehicleType getType() {
        return VehicleType.Car;
    }

    @Override
    public String[] getInformationAsArray() {
        return carInformation;
    }
}
