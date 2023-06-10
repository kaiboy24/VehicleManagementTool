package GUI;

import GUI.VehicleControlling.VehicleControlFactory;
import Vehicles.VehicleProperties.VehicleType;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private DefaultTableModel model;
    private VehicleType vehicleType;

    public Controller(DefaultTableModel model, VehicleType vehicleType){
        super();
        this.model  = model;
        this.vehicleType = vehicleType;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        VehicleControlFactory.setAction(e, vehicleType);
    }

}
