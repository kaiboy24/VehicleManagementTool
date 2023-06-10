package GUI.VehicleButtons;

import GUI.Controller;
import Vehicles.VehicleProperties.VehicleType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public abstract class VehicleButtons {
    protected final JButton buttonAddVehicle = new JButton();
    protected final JButton buttonSearchVehicle = new JButton();
    protected final JButton buttonDeleteVehicle = new JButton();
    protected final JButton buttonSaveVehicles = new JButton();

    protected JPanel vehiclePanel = new JPanel();

    protected VehicleButtons(JTable table, VehicleType vehicleType, DefaultTableModel model){

        String typeName = vehicleType.name();
        buttonAddVehicle.setText("Add " + typeName); buttonAddVehicle.setActionCommand("Add " + typeName);
        buttonSearchVehicle.setText("Search " + typeName); buttonSearchVehicle.setActionCommand("Search " + typeName);
        buttonDeleteVehicle.setText("Delete " + typeName); buttonDeleteVehicle.setActionCommand("Delete " + typeName);
        buttonSaveVehicles.setText("Save " + typeName+"(s)"); buttonSaveVehicles.setActionCommand("Save " + typeName+"(s)");

        buttonAddVehicle.addActionListener(new Controller(model, vehicleType));
        buttonSearchVehicle.addActionListener(new Controller(model, vehicleType));
        buttonDeleteVehicle.addActionListener(new Controller(model, vehicleType));
        buttonSaveVehicles.addActionListener(new Controller(model, vehicleType));

        vehiclePanel.add(buttonAddVehicle);vehiclePanel.add(buttonSearchVehicle); vehiclePanel.add(buttonDeleteVehicle);
        vehiclePanel.add(buttonSaveVehicles);
    }

    public JPanel getPanel(){return vehiclePanel;}


}
