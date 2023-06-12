package GUI.VehicleControlling;

import GUI.View;
import Operations.AddVehicle;
import Vehicles.CarProperties.CarType;
import Vehicles.CarProperties.HeatedSeats;
import Vehicles.VehicleFactory;
import Vehicles.VehicleProperties.VehicleType;

import javax.swing.*;
import java.util.Arrays;

public class CarControl extends VehicleControl {
    private static JComboBox carType = new JComboBox(Arrays.stream(CarType.values())
            .map(carType -> carType.toString()).toArray(String[]::new));
    private JComboBox  heatedSeats = new JComboBox(Arrays.stream(HeatedSeats.values())
            .map(heatedSeats -> heatedSeats.toString().replace("_", " ")).toArray(String[]::new));

    private JTextField cargoSpace = new JTextField("Cargo space",4);
    private JTextField amountOfSeats = new JTextField("Amount of seats",2);

    public CarControl(){
        super(View.carModel, VehicleType.Car, View.carTable);
        this.panel.add(cargoSpace); this.panel.add(heatedSeats); this.panel.add(amountOfSeats); this.panel.add(carType);
    }
    public void addAction(){
        UIManager.put("OptionPane.okButtonText", "Add");
        boolean checkIfValid = false;
        while (!checkIfValid) {
            int n = JOptionPane.showConfirmDialog(null,panel,"Add a vehicle"
                    ,JOptionPane.CANCEL_OPTION);
            if(n == JOptionPane.CANCEL_OPTION){break;}
            checkIfValid = checkValidNumbers((String) constructionOfYearText.getSelectedItem()) &&
                    checkValidNumbers(mileageText.getText()) && checkValidNumbers(cargoSpace.getText()) &&
                    checkValidNumbers(amountOfSeats.getText());
        }
        if(checkIfValid){
            AddVehicle.addVehicle(VehicleFactory.newVehicle(vehicleType, getText()));
            model.addRow(VehicleFactory.newVehicle(vehicleType, getText()).getTable());
        }

    }


    @Override
    public String[] getText() {
        return new String[]{(String) brandOptions.getSelectedItem(), modelText.getText(),
                (String) constructionOfYearText.getSelectedItem(), mileageText.getText(), (String) conditionOptions.getSelectedItem(),
                (String) fuelKindOptions.getSelectedItem(), cargoSpace.getText(),
                ((String) heatedSeats.getSelectedItem()).replace(" ", "_"),
                amountOfSeats.getText(), (String) carType.getSelectedItem()};
    }
}
