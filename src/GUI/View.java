package GUI;

import GUI.VehicleButtons.VehicleButtonsFactory;
import Vehicles.VehicleProperties.VehicleType;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class View {
    public static JTable carTable;
    public static JTable motorcycleTable ;
    public static DefaultTableModel carModel;
    public static DefaultTableModel motorcycleModel;

    public View(){
        init();
    }

    private void init(){
        carModel = Model.getModel(VehicleType.Car);
        motorcycleModel =Model.getModel(VehicleType.Motorcycle);

        carTable = new JTable();
        motorcycleTable = new JTable();

        carTable.setModel(carModel);
        motorcycleTable.setModel(motorcycleModel);

        JScrollPane scrollPaneCar = new JScrollPane(carTable);
        scrollPaneCar.setPreferredSize(new Dimension(900,250));
        scrollPaneCar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Registered cars", TitledBorder.CENTER, TitledBorder.TOP));

        JScrollPane scrollPaneMotorcycle = new JScrollPane(motorcycleTable);
        scrollPaneMotorcycle.setPreferredSize(new Dimension(900,250));
        scrollPaneMotorcycle.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Registered motorcycles", TitledBorder.CENTER, TitledBorder.TOP));

        JSplitPane carPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, VehicleButtonsFactory.getPanel(VehicleType.Car),
                scrollPaneCar);
        carPane.setDividerLocation(40);

        JSplitPane motorcyclePane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                VehicleButtonsFactory.getPanel(VehicleType.Motorcycle) , scrollPaneMotorcycle);
        motorcyclePane.setDividerLocation(40);

        JSplitPane splitCarMotorcycle = new JSplitPane(JSplitPane.VERTICAL_SPLIT, carPane, motorcyclePane);
        splitCarMotorcycle.setDividerLocation(250);
        splitCarMotorcycle.setEnabled(false);

        JFrame frame = new JFrame("Vehicle Book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(splitCarMotorcycle);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
