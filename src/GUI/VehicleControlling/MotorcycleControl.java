package GUI.VehicleControlling;

import GUI.View;
import Vehicles.MotorcycleProperties.LuggageRack;
import Vehicles.MotorcycleProperties.MotorcycleType;
import Vehicles.MotorcycleProperties.PillonSeat;
import Vehicles.VehicleProperties.VehicleType;

import javax.swing.*;
import java.util.Arrays;

public class MotorcycleControl extends VehicleControl {
    private static JComboBox luggageRack = new JComboBox(Arrays.stream(LuggageRack.values())
            .map(luggageRack -> luggageRack.toString().replace("_", " ")).toArray(String[]::new));
    private static JComboBox pillionSeat = new JComboBox(Arrays.stream(PillonSeat.values())
            .map(pillonSeat -> pillonSeat.toString().replace("_", " ")).toArray(String[]::new));
    private static JComboBox motorcycleType = new JComboBox(Arrays.stream(MotorcycleType.values())
            .map(motorcycleType -> motorcycleType.toString()).toArray(String[]::new));

    public MotorcycleControl(){
        super(View.motorcycleModel, VehicleType.Motorcycle, View.motorcycleTable);
        this.panel.add(luggageRack); this.panel.add(pillionSeat); this.panel.add(motorcycleType);
    }

    @Override
    public String[] getText() {
        return new String[]{(String) brandOptions.getSelectedItem(), modelText.getText(),
                (String) constructionOfYearText.getSelectedItem(), mileageText.getText(), (String) conditionOptions.getSelectedItem(),
                (String) fuelKindOptions.getSelectedItem(),
                ((String) luggageRack.getSelectedItem()).replace(" ", "_"),
                ((String) pillionSeat.getSelectedItem()).replace(" ", "_"),
                (String) motorcycleType.getSelectedItem()};
    }
}
