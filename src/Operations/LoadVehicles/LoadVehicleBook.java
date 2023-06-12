package Operations.LoadVehicles;

import Vehicles.VehicleFactory;
import Vehicles.VehicleProperties.VehicleType;
import Vehicles.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LoadVehicleBook implements Loader {
    private void loadVehicleBook(HashMap<Vehicle, Vehicle> vehicles, String source, VehicleType vehicleType){
        String[] vehicleInformation;
        try{
            FileReader FR = new FileReader(source);
            BufferedReader BR = new BufferedReader(FR);
            String line = BR.readLine();

            while (line != null){
                vehicleInformation = line.split(",");
                for(int i = 0; i < vehicleInformation.length; i++){
                    vehicleInformation[i] = vehicleInformation[i].replace("_", " ");
                }
                Vehicle currentVehicle = VehicleFactory.newVehicle(vehicleType, vehicleInformation);
                vehicles.put(currentVehicle, currentVehicle);
                line = BR.readLine();
            }
            BR.close();
            FR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load(HashMap<Vehicle, Vehicle> vehicles, String source, VehicleType vehicleType) {
        loadVehicleBook(vehicles, source, vehicleType);
    }
    @Override
    public void load(VehicleType vehicleType) {
        loadVehicleBook(vehicleType.getMap(), vehicleType.name()+".txt", vehicleType);
    }
}
