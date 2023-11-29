package UparuMountainGUI.view;

import javax.swing.*;
import java.awt.event.*;

import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.model.Farm;
import UparuMountainGUI.model.Observer;

public class FarmPanel extends JPanel implements Observer{
    private CreatePanel cPanel;   

    private JList<Farm> farmList = new JList<Farm>();

    private JButton harvestBtn = new JButton("Harvest Fruit");
    private JButton backBtn = new JButton("Back");

    public FarmPanel(CreatePanel cPanel) {
        setup();
        build();
        this.cPanel = cPanel;
    }

    public void setup() {
        harvestBtn.addActionListener(new Listener("harvestFruit"));
        backBtn.addActionListener(new Listener("main"));
    }

    public void build() {
        add(farmList);
        add(harvestBtn);
        add(backBtn);
    }

    @Override
    public void update() {
    }

    private class Listener implements ActionListener {
        String goTo;

        Listener(String goTo) {
            this.goTo = goTo;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            cPanel.getCardLayout().show(cPanel, goTo);
        }
    }
}
