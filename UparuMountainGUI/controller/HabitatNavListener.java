package UparuMountainGUI.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UparuMountainGUI.view.HabitatPanel;

public class HabitatNavListener implements ActionListener{
    HabitatPanel habitatPanel;
    String destination;

    public HabitatNavListener(HabitatPanel habitatPanel, String destination) {
        this.habitatPanel = habitatPanel;
        this.destination = destination;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        habitatPanel.getCard().show(habitatPanel, destination);
    }
}
