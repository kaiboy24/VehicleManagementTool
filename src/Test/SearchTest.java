package Test;

import Vehicles.VehicleFactory;
import Vehicles.VehicleProperties.VehicleType;
import Operations.Load;
import Operations.Search;
import VehicleBook.VehicleBook;
import Vehicles.Car;
import Vehicles.Motorcycle;
import Vehicles.Vehicle;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest{
    String[] c1 = {"Toyota","Fortuner","2018","6000","Used","Petrol","200","no heated seats","7","SUV"};
    String[] c2 = {"Skoda","Octavia","2023","27000","Used","Diesel","490","heated seats installed","5","Sedan"};
    String[] c3 = {"Volkswagen","Golf","2021","4000","Used","Diesel","380","heated seats installed","5","Hatchback"};
    String[] m1 = {"Ducati","Monster","2022","600","Used","Gas","no luggage rack","pillon seat installed","Sports"};
    String[] m2 = {"BMW","CE 04","2023","100","New","Electric","luggage rack installed","pillon seat installed","Standard"};

    @BeforeAll
    static void init(){
        Load.load();
    }
    @AfterAll
    static void clearMap(){
        VehicleBook.Cars.clear();
        VehicleBook.Motorcycles.clear();
    }
    @Test
    void searchSpecificCar() {
        assertTrue(Search.search(VehicleType.Car, c1).contains(VehicleFactory.newVehicle(VehicleType.Car,c1)));
        assertTrue(Search.search(VehicleType.Car, c2).contains(VehicleFactory.newVehicle(VehicleType.Car,c2)));
        assertTrue(Search.search(VehicleType.Car, c3).contains(VehicleFactory.newVehicle(VehicleType.Car,c3)));
    }
    @Test
    void searchSpecificMotorcycle(){
        assertTrue(Search.search(VehicleType.Motorcycle, m1).contains(VehicleFactory.newVehicle(VehicleType.Motorcycle,m1)));
        assertTrue(Search.search(VehicleType.Motorcycle, m2).contains(VehicleFactory.newVehicle(VehicleType.Motorcycle,m2)));
    }
    @Test
    void searchMultipleCars(){
        String[] searchKeys = {"", "", "", "", "", "Diesel", "", "", "", ""};
        List<Vehicle> searchResults = Search.search(VehicleType.Car, searchKeys);
        assertFalse(searchResults.contains(VehicleFactory.newVehicle(VehicleType.Car,c1)));
        assertTrue(searchResults.contains(VehicleFactory.newVehicle(VehicleType.Car,c2)));
        assertTrue(searchResults.contains(VehicleFactory.newVehicle(VehicleType.Car,c3)));
    }
}