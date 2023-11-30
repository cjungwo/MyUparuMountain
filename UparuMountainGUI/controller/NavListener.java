package UparuMountainGUI.controller;

import java.awt.event.*;

import UparuMountainGUI.UparuMountainWindow.CreatePanel;

public class NavListener implements ActionListener {
    CreatePanel createPanel;
    String destination;

    public NavListener(CreatePanel createPanel, String destination) {
        this.createPanel = createPanel;
        this.destination = destination;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        createPanel.getCardLayout().show(createPanel, destination);
    }
}
