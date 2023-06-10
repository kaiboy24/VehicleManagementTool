package Vehicles;

import Vehicles.VehicleProperties.VehicleType;
import Vehicles.VehicleProperties.Brand;
import Vehicles.VehicleProperties.Condition;
import Vehicles.VehicleProperties.FuelKind;

import java.util.Objects;

public abstract class Vehicle {
    protected Brand brand;
    protected String model;
    protected Condition condition;
    protected String mileage;
    protected String constructionOfYear;
    protected FuelKind fuelKind;
    //String[] inputVehicle = {String brand, String model, String constructionOfYear, String mileage, String condition, String fuelKind}
    protected Vehicle(String[] inputVehicle) {
        this.brand = Brand.valueOf(inputVehicle[0].replace(" ", "_"));
        this.model = inputVehicle[1];
        this.constructionOfYear = inputVehicle[2];
        this.mileage = inputVehicle[3];
        this.condition = Condition.valueOf(inputVehicle[4].replace(" ", "_"));
        this.fuelKind = FuelKind.valueOf(inputVehicle[5].replace(" ", "_"));
    }

    public abstract String[] getTable();
    public abstract VehicleType getType();
    public abstract String[] getInformationAsArray();



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
