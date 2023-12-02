package UparuMountainGUI.view;

import javax.swing.*;

import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.controller.NavListener;
import UparuMountainGUI.model.Farm;
import UparuMountainGUI.model.Observer;

public class FarmPanel extends JPanel implements Observer{
    private CreatePanel cPanel;   

    private JList<Farm> farmList = new JList<Farm>();

    private JButton harvestBtn = new JButton("Harvest Fruit");
    private JButton backBtn = new JButton("Back");

    public FarmPanel(CreatePanel cPanel) {
        this.cPanel = cPanel;
        setup();
        build();
    }

    public void setup() {
        harvestBtn.addActionListener(new NavListener(cPanel, "harvestFruit"));
        backBtn.addActionListener(new NavListener(cPanel, "main"));
    }

    public void build() {
        add(farmList);
        add(harvestBtn);
        add(backBtn);
    }

    @Override
    public void update() {

    }
}
