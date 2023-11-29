package UparuMountainGUI.view;

import javax.swing.*;
import java.awt.event.*;

import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.model.Observer;

public class ShopPanel extends JPanel implements Observer{
    private CreatePanel cPanel;   

    private JButton habitatListBtn = new JButton("Habitat");
    private JButton uparuListBtn = new JButton("Uparu");
    private JButton farmListBtn = new JButton("Farm");
   
    private JButton backBtn = new JButton("Back");

    public ShopPanel(CreatePanel cPanel) {
        setup();
        build();
        this.cPanel = cPanel;
    }

    public void setup() {
        habitatListBtn.addActionListener(new Listener("feed"));
        uparuListBtn.addActionListener(new Listener("feed"));
        farmListBtn.addActionListener(new Listener("feed"));       
        backBtn.addActionListener(new Listener("main"));
    }

    public void build() {
        add(habitatListBtn);
        add(uparuListBtn);
        add(farmListBtn);
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
