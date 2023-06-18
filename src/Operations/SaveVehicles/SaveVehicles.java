package Operations.SaveVehicles;

import Vehicles.Vehicle;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class SaveVehicles implements Saver {
    @Override
    public void save(String target, HashMap<Vehicle, Vehicle> vehicles){ /*saves vehicle Hashmap
    to their corresponding txt file*/
        try{
            String currentLine;
            FileWriter fw = new FileWriter(target);
            PrintWriter pw = new PrintWriter(fw);
            ArrayList<Vehicle> currentVehicles = new ArrayList<>(vehicles.values());
            int size = currentVehicles.get(0).vehicleInformation.size();
            for (Vehicle vehicle: currentVehicles){
                String[] vehicleInformation = vehicle.getInformationAsArray();
                for(int i = 0; i < vehicleInformation.length; i++){
                    vehicleInformation[i] = vehicleInformation[i].replaceAll(" ", "_");
                }
                currentLine = vehicleInformation[0] + ",";
                for(int i = 1; i < size; i++){
                    currentLine = currentLine + vehicleInformation[i] + ",";
                }
                pw.println(currentLine);
            }
            pw.flush();
            pw.close();
            fw.close();

        }catch (IOException ioEx){
            System.out.println(ioEx);
        }
    }

}
