package UparuMountainGUI.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import UparuMountainGUI.UparuMountainWindow;
import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.controller.NavListener;
import UparuMountainGUI.controller.NumberInputListener;
import UparuMountainGUI.model.Farm;
import UparuMountainGUI.model.Farms;
import UparuMountainGUI.model.Inventory;
import UparuMountainGUI.model.Observer;
import UparuMountainGUI.model.User;

public class FarmPanel extends JPanel implements Observer{
    private CreatePanel cPanel;   

    private User user = User.getInstance();
    private Inventory inventory = user.getInventory();
    private Farms farms = user.getFarms();

    private JLabel farmList = new JLabel("", JLabel.CENTER);
    private JScrollPane scroller = new JScrollPane(farmList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    private JLabel msgLabel = new JLabel("", JLabel.CENTER);
    private JLabel warningMsg = new JLabel("", JLabel.CENTER);
    private JTextField selectField = new JTextField(20);
    private JButton selectBtn = new JButton("Select");

    private JButton harvestBtn = new JButton("Harvest Fruit");
    private JButton backBtn = new JButton("Back");

    public FarmPanel(CreatePanel cPanel) {
        this.cPanel = cPanel;
        setup();
        build();
        farms.attach(this);
    }

    public void setup() {
        farmList.setText(farms.toString());
        scroller.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 400));

        if (farms.getSize() == 0) {
            harvestBtn.setVisible(false);
        }

        selectBtn.addActionListener(new SelectListener());
        harvestBtn.addActionListener(new HarvestFruitListener());
        backBtn.addActionListener(new NavListener(cPanel, "main"));

        msgLabel.setVisible(false);
        warningMsg.setVisible(false);
        selectField.setVisible(false);
        selectBtn.setVisible(false);
    }

    public void build() {
        add(scroller);
        add(msgLabel);
        add(warningMsg);
        add(selectField);
        add(selectBtn);
        add(harvestBtn);
        add(backBtn);
    }

    @Override
    public void update() {
        if (farms.getSize() != 0) {
            harvestBtn.setVisible(true);
            farmList.setText(farms.toString());
            selectField.addKeyListener(new NumberInputListener(farms.getSize(), selectField, warningMsg));
        }
    }

    private class HarvestFruitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            msgLabel.setText("Which farm do you want to harvest?");
            msgLabel.setVisible(true);
            warningMsg.setVisible(true);
            selectField.setVisible(true);
            selectBtn.setVisible(true);
        }
    }
    private class SelectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Farm farm = farms.find(Integer.parseInt(selectField.getText()));
            selectField.setVisible(false);
            harvestBtn.setVisible(false);

            msgLabel.setText("<html><p style='text-align:center'>Your choice is " + farm.getName() + " farm. <br>It takes " + farm.getProducingTime() + "seconds</p></html>");
            selectBtn.removeActionListener(this);
            selectBtn.addActionListener(new HarvestListener(farm));
            selectBtn.setText("Harvest");
        }
    }

    private class HarvestListener implements ActionListener {
        private Farm farm;

        HarvestListener(Farm farm) {
            this.farm = farm;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            farm.harvestFruit(inventory);
            msgLabel.setText("<html><p style='text-align:center'>Success!!! You harvested " + farm.getProducingAmount() + " fruits.</p></html>");
        }
    }

}
