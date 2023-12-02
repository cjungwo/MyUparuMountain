package UparuMountainGUI.view;

import javax.swing.*;

import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.controller.NavListener;
import UparuMountainGUI.model.Habitat;
import UparuMountainGUI.model.Observer;

public class HabitatPanel extends JPanel implements Observer{
    private CreatePanel cPanel;   

    private JList<Habitat> habitatList = new JList<Habitat>();

    private JButton showUparuBtn = new JButton("Show Uparu");
    private JButton harvestBtn = new JButton("Harvest Money");
    private JButton backBtn = new JButton("Back");

    public HabitatPanel(CreatePanel cPanel) {
        this.cPanel = cPanel;
        setup();
        build();
    }

    public void setup() {
        showUparuBtn.addActionListener(new NavListener(cPanel, "uparu"));
        harvestBtn.addActionListener(new NavListener(cPanel, "harvestMoney"));
        backBtn.addActionListener(new NavListener(cPanel, "main"));
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
}
