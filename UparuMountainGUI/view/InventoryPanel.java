package UparuMountainGUI.view;

import javax.swing.*;
import java.awt.event.*;

import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.model.Observer;

public class InventoryPanel extends JPanel implements Observer{
    private CreatePanel cPanel;   

    private JLabel moneyLabel = new JLabel("Money");
    private JLabel fruitLabel = new JLabel("Fruit");
    private JButton backBtn = new JButton("Back");

    public InventoryPanel(CreatePanel cPanel) {
        setup();
        build();
        this.cPanel = cPanel;
    }

    public void setup() {
        backBtn.addActionListener(new Listener("main"));
    }

    public void build() {
        add(moneyLabel);
        add(fruitLabel);
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
