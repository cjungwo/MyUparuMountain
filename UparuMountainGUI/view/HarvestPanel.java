package UparuMountainGUI.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import UparuMountainGUI.UparuMountainWindow;
import UparuMountainGUI.controller.HabitatNavListener;
import UparuMountainGUI.model.Habitat;
import UparuMountainGUI.model.Observer;

public class HarvestPanel extends JPanel implements Observer {
    private HabitatPanel hPanel;
    private Habitat habitat;

    private JLabel listLabel = new JLabel("", JLabel.CENTER);
    private JScrollPane scroller = new JScrollPane(listLabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private JButton backBtn = new JButton("Back");

    public HarvestPanel(HabitatPanel hPanel) {
        this.hPanel = hPanel;
        setup();
        build();
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
        listLabel.setText(habitat.getUparusInHabitat().toString());
    }

    private void setup() {
        scroller.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 400));
        backBtn.addActionListener(new HabitatNavListener(hPanel, "lobby"));
    }

    private void build() {
        add(scroller);
        add(backBtn);
    }


    @Override
    public void update() {

    } 
}

