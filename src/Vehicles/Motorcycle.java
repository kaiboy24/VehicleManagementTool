package Vehicles;

import Vehicles.VehicleProperties.VehicleType;

import java.util.Arrays;

public class Motorcycle extends Vehicle {
    private String[] motorInformation;
    private String[] table;

    /*String[] inputVehicle = {String brand, String model, String constructionOfYear, String mileage,
     String condition, String fuelKind, String luggageRack, String pillionSeat, String motorcycleType}*/
    protected Motorcycle(String[] inputMotorcycle){
        super(Arrays.copyOfRange(inputMotorcycle, 0,6));
        this.table = Arrays.copyOf(inputMotorcycle,10);
        this.motorInformation = inputMotorcycle;
    }


    @Override
    public String[] getTable() {
        return table;
    }



    @Override
    public VehicleType getType() {
        return VehicleType.Motorcycle;
    }

    @Override
    public String[] getInformationAsArray() {
        return motorInformation;
    }

}
