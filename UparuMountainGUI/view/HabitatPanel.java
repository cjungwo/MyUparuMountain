package UparuMountainGUI.view;

import javax.swing.*;
import java.awt.event.*;

import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.model.Habitat;
import UparuMountainGUI.model.Observer;

public class HabitatPanel extends JPanel implements Observer{
    private CreatePanel cPanel;   

    private JList<Habitat> habitatList = new JList<Habitat>();

    private JButton showUparuBtn = new JButton("Show Uparu");
    private JButton harvestBtn = new JButton("Harvest Money");
    private JButton backBtn = new JButton("Back");

    public HabitatPanel(CreatePanel cPanel) {
        setup();
        build();
        this.cPanel = cPanel;
    }

    public void setup() {
        showUparuBtn.addActionListener(new Listener("uparu"));
        harvestBtn.addActionListener(new Listener("harvestMoney"));
        backBtn.addActionListener(new Listener("main"));
    }

    public void build() {
        add(habitatList);
        add(showUparuBtn);
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
