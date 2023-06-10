package Test;

import Vehicles.VehicleFactory;
import Vehicles.VehicleProperties.VehicleType;
import Operations.Save;
import Vehicles.Car;
import Vehicles.Motorcycle;
import Vehicles.Vehicle;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SaveVehiclesTest {
    Vehicle c1 = VehicleFactory.newVehicle(VehicleType.Car,
            new String[]{"Toyota","Fortuner","2018","6000","Used","Petrol","200","no_heated_seats","7","SUV"});
    Vehicle c2 = VehicleFactory.newVehicle(VehicleType.Car,
            new String[]{"Skoda","Octavia","2023","27000","Used","Diesel","490","heated_seats_installed","5","Sedan"});
    Vehicle c3 = VehicleFactory.newVehicle(VehicleType.Car,
            new String[]{"Volkswagen","Golf","2021","4000","Used","Diesel","380","heated_seats_installed","5","Hatchback"});
    Vehicle m1 =VehicleFactory.newVehicle(VehicleType.Motorcycle,
            new String[]{"Ducati","Monster","2022","600","Used","Gas","no_luggage_rack","pillon_seat_installed","Sports"});
    Vehicle m2 = VehicleFactory.newVehicle(VehicleType.Motorcycle,
            new String[]{"BMW","CE 04","2023","100","New","Electric","luggage_rack_installed","pillon_seat_installed","Standard"});

    @AfterAll
    static void clearFiles(){
        new File("Car_SaveTesting.txt").delete();
        new File("Motorcycle_SaveTesting.txt").delete();



    }
    @Test
    void saveMapToFile() {
        HashMap<Vehicle, Vehicle> testCars = new HashMap<>();
        testCars.put(c1,c1); testCars.put(c2,c2); testCars.put(c3,c3);
        HashMap<Vehicle, Vehicle> testMotorcycles = new HashMap<>();
        testMotorcycles.put(m1,m1); testMotorcycles.put(m2,m2);
        Save.save(VehicleType.Car, testCars); Save.save(VehicleType.Motorcycle, testMotorcycles);
        File carFile = new File("Car_SaveTesting.txt");
        File motorcycleFile = new File("Motorcycle_SaveTesting.txt");
        assertTrue(carFile.exists()); assertTrue(motorcycleFile.exists());
    }

}