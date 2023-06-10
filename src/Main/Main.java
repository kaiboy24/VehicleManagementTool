package Main;

import GUI.View;
import VehicleBook.VehicleBook;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        VehicleBook VB = VehicleBook.getInstance();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    createAndShowGUI();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    private static void createAndShowGUI() throws Exception {
        new View();
    }
}
