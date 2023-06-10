package Vehicles.VehicleProperties;

public enum FuelKind {
    Electric, Gas, Petrol, Diesel;

    public FuelKind stringToFuelKind(String fuel){
        switch(fuel){
            case "Electric":
                return Electric;
            case "Gas":
                return Gas;
            case "Petrol":
                return Petrol;
            case "Diesel":
                return Diesel;
            default:
                return null;
        }
    }
}
