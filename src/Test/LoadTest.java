package Test;

import Vehicles.VehicleFactory;
import Vehicles.VehicleProperties.VehicleType;
import Operations.Load;
import VehicleBook.VehicleBook;
import Vehicles.Car;
import Vehicles.Motorcycle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LoadTest {

    String[] c1 = {"Toyota","Fortuner","2018","6000","Used","Petrol","200","no heated seats","7","SUV"};
    String[] c2 = {"Skoda","Octavia","2023","27000","Used","Diesel","490","heated seats installed","5","Sedan"};
    String[] c3 = {"Volkswagen","Golf","2021","4000","Used","Diesel","380","heated seats installed","5","Hatchback"};
    String[] m1 = {"Ducati","Monster","2022","600","Used","Gas","no luggage rack","pillon seat installed","Sports"};
    String[] m2 = {"BMW","CE 04","2023","100","New","Electric","luggage rack installed","pillon seat installed","Standard"};

    @AfterEach
    void clearMap(){
        VehicleBook.Cars.clear();
        VehicleBook.Motorcycles.clear();
    }
    
    @Test
    void defaultLoadTest() {
        Load.load();
        assertTrue(VehicleBook.Cars.containsKey(VehicleFactory.newVehicle(VehicleType.Car,c1)));
        assertTrue(VehicleBook.Cars.containsKey(VehicleFactory.newVehicle(VehicleType.Car,c2)));
        assertTrue(VehicleBook.Cars.containsKey(VehicleFactory.newVehicle(VehicleType.Car,c3)));
        assertTrue(VehicleBook.Motorcycles.containsKey(VehicleFactory.newVehicle(VehicleType.Motorcycle,m1)));
        assertTrue(VehicleBook.Motorcycles.containsKey(VehicleFactory.newVehicle(VehicleType.Motorcycle,m2)));
    }

    @Test
    void specificVehicleLoadTest() {
        Load.load(VehicleBook.Cars, "Testing_Car.txt", VehicleType.Car);
        assertTrue(VehicleBook.Cars.containsKey((VehicleFactory.newVehicle(VehicleType.Car,c1))));
        assertTrue(VehicleBook.Cars.containsKey((VehicleFactory.newVehicle(VehicleType.Car,c2))));
        assertTrue(VehicleBook.Cars.containsKey((VehicleFactory.newVehicle(VehicleType.Car,c3))));
    }
}