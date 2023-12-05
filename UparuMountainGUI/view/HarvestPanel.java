package UparuMountainGUI.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import UparuMountainGUI.UparuMountainWindow;
import UparuMountainGUI.controller.HabitatNavListener;
import UparuMountainGUI.model.Habitat;
import UparuMountainGUI.model.Inventory;
import UparuMountainGUI.model.Observer;
import UparuMountainGUI.model.User;

public class HarvestPanel extends JPanel implements Observer {
    private User user = User.getInstance();

    private Habitat habitat;
    private Inventory inventory = user.getInventory();

    private HabitatPanel hPanel;

    private JLabel listLabel = new JLabel("", JLabel.CENTER);
    private JScrollPane scroller = new JScrollPane(listLabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    private JLabel msgLabel = new JLabel("", JLabel.CENTER);
    private JButton harvestBtn = new JButton("Harvest");
    private JButton backBtn = new JButton("Back");

    public HarvestPanel(HabitatPanel hPanel, HarvestPanel harvestPanel) {
        this.hPanel = hPanel;
        setup();
        build();
        inventory.attach(this);
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
        habitat.attach(this);
        habitat.getUparusInHabitat().attach(this);
        update();
    }

    private void setup() {
        scroller.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 400));

        harvestBtn.addActionListener(new HarvestBtnListener());
        backBtn.addActionListener(new HabitatNavListener(hPanel, "lobby"));
    }

    private void build() {
        add(scroller);

        add(msgLabel);
        add(harvestBtn);
        add(backBtn);
    }

    @Override
    public void update() {
        if (habitat != null) {
            listLabel.setText("<html><p style='text-align:center'>" + habitat.getUparusInHabitat().toString() + "</p></html>");
            msgLabel.setText("<html><p style='text-align:center'>You can harvest total " + habitat.calculateProducedMoney() + ". <br> It takes 5 seconds.</p></html>");
        }
    }

    private class HarvestBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) { 
            msgLabel.setText("Success!! You harvested " + habitat.harvestMoney(inventory) + ".");
        }
    }
}

