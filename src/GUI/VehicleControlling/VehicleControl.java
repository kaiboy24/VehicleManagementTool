package GUI.VehicleControlling;

import Operations.AddVehicle;
import Operations.Delete;
import Operations.Save;
import Operations.Search;
import Vehicles.VehicleFactory;
import Vehicles.VehicleProperties.Brand;
import Vehicles.VehicleProperties.Condition;
import Vehicles.VehicleProperties.FuelKind;
import Vehicles.VehicleProperties.VehicleType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public abstract class VehicleControl {
    public static final String[] ColumnNames = new String[]{
            "Brand", "Model", "Construction of year", "Mileage", "Condition"
    };
    protected static List<String> listOfYears = new LinkedList<>();


    final static JComboBox brandOptions = new JComboBox(Arrays.stream(Brand.values())
            .map(brand -> brand.toString()).toArray(String[]::new));
    final static JComboBox conditionOptions = new JComboBox(Arrays.stream(Condition.values())
            .map(condition -> condition.toString()).toArray(String[]::new));
    final static JComboBox fuelKindOptions = new JComboBox(Arrays.stream(FuelKind.values())
            .map(fuelKind -> fuelKind.toString()).toArray(String[]::new));
    static JComboBox constructionOfYearText;


    protected final JPanel panel = new JPanel(new GridLayout(5, 15));

    final JTextField modelText = new JTextField("Model", 15);
    final JTextField mileageText = new JTextField("Mileage", 6);
    protected DefaultTableModel model;
    protected VehicleType vehicleType;
    protected JTable vehicleTable;

    public VehicleControl(DefaultTableModel model, VehicleType vehicleType, JTable vehicleTable) {
        for(int year = 1980; year<= Calendar.getInstance().get(Calendar.YEAR); year++) {
            listOfYears.add(year+"");
        }
        this.constructionOfYearText = new JComboBox(Arrays.stream(listOfYears.toArray())
                .map(year -> year.toString()).toArray(String[]::new));

        this.model = model;
        this.vehicleType = vehicleType;
        this.vehicleTable = vehicleTable;
        panel.add(brandOptions);
        panel.add(modelText);
        panel.add(constructionOfYearText);
        panel.add(mileageText);
        panel.add(conditionOptions);
        panel.add(fuelKindOptions);
    }

    public void selectAction(ActionEvent e) {

        if (e.getActionCommand().equals("Add " + vehicleType.name())) {
            addAction();
        } else if (e.getActionCommand().equals("Search " + vehicleType.name())) {
            searchAction();
        } else if (e.getActionCommand().equals("Delete " + vehicleType.name())) {
            deleteAction();
        } else if (e.getActionCommand().equals("Save " + vehicleType.name() + "(s)")) {
            saveAction();
        }
    }

    public void addAction() { //adds vehicle(s) to tables as well as to the corresponding Hashmap
        UIManager.put("OptionPane.okButtonText", "Add");
        boolean checkIfValid = false;
        while (!checkIfValid) {
            int n = JOptionPane.showConfirmDialog(null,panel,"Add a vehicle"
                    ,JOptionPane.CANCEL_OPTION);
            if(n == JOptionPane.CANCEL_OPTION){break;}
            checkIfValid = checkValidNumbers((String) constructionOfYearText.getSelectedItem()) &&
                    checkValidNumbers(mileageText.getText());
        }
        if(checkIfValid){
            AddVehicle.addVehicle(VehicleFactory.newVehicle(vehicleType, getText()));
            model.addRow(VehicleFactory.newVehicle(vehicleType, getText()).getTable());
        }
    }

    public void searchAction() { //searches and returns Vehicles in a table
        UIManager.put("OptionPane.okButtonText", "Search");
        JOptionPane.showMessageDialog(null, panel);
        List<String[]> tmp = new LinkedList<>();
        Search.search(vehicleType, getText()).forEach(vehicle -> tmp.add(vehicle.getTable()));
        JOptionPane.showMessageDialog(null, new JScrollPane(new JTable(tmp.toArray(String[][]::new), ColumnNames)));
    }

    public void deleteAction() { // deletes vehicles from table as well as from their corresponding Hashmap
        if (vehicleTable.getSelectedRow() != -1) {
            String[] vehicleToDelete = new String[vehicleTable.getColumnCount()];
            for (int i = 0; i < vehicleTable.getColumnCount(); i++) {
                vehicleToDelete[i] = vehicleTable.getValueAt(vehicleTable.getSelectedRow(), i).toString();
            }
            Delete.deleteVehicle(VehicleFactory.newVehicle(vehicleType, vehicleToDelete));
            model.removeRow(vehicleTable.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Selected vehicle deleted");
        }
    }

    public void saveAction() {//saves vehicles from table/Hashmap to a txt file named according to the vehicle type
        Save.save(vehicleType);
        JOptionPane.showMessageDialog(null, "Vehicle saved");
    }

    protected boolean checkValidNumbers(String number) { //checks if input is numeric and positive
        try {
            if (Double.parseDouble(number) < 0) {
                JOptionPane.showMessageDialog(null, "Negative numbers not possible",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Only numerical values for properties described by numbers",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public abstract String[] getText();
}

