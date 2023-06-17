package Vehicles;

import Vehicles.VehicleProperties.Brand;
import Vehicles.VehicleProperties.Condition;
import Vehicles.VehicleProperties.VehicleType;
import Vehicles.VehicleProperties.FuelKind;

import java.util.HashMap;
import java.util.Objects;

public abstract class Vehicle {
    protected Brand brand;
    protected String model;
    protected Condition condition;
    protected String mileage;
    protected String constructionOfYear;
    protected FuelKind fuelKind;

    public HashMap<String, String> vehicleInformation;

    //String[] inputVehicle = {String brand, String model, String constructionOfYear, String mileage, String condition, String fuelKind}
    protected static String[] carPropertyNames;
    protected Vehicle(HashMap<String, String> vehicleInformation, String[] motorcyclePropertyNames) {
        this.fuelKind = FuelKind.valueOf(vehicleInformation.get("Fuel kind"));
        this.brand = Brand.valueOf(vehicleInformation.get("Brand"));
        this.condition = Condition.valueOf(vehicleInformation.get("Condition"));
        this.constructionOfYear = vehicleInformation.get("Construction of year");
        this.model = vehicleInformation.get("Model");
        this.mileage = vehicleInformation.get("Mileage");

        this.vehicleInformation = vehicleInformation;
        this.carPropertyNames = motorcyclePropertyNames;
    }

    public abstract String[] getInformationAsArray();


    public abstract VehicleType getType();





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return fuelKind == vehicle.fuelKind && model.equals(vehicle.model) && condition == vehicle.condition &&
                mileage.equals(vehicle.mileage) && constructionOfYear.equals(vehicle.constructionOfYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuelKind, model, condition, mileage, constructionOfYear);
    }
}
