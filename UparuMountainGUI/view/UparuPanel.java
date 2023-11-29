package UparuMountainGUI.view;

import javax.swing.*;
import java.awt.event.*;

import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.model.Observer;

public class UparuPanel extends JPanel implements Observer{
    private CreatePanel cPanel;   

    private JButton feedBtn = new JButton("Feed Uparu");
    private JButton backBtn = new JButton("Back");

    public UparuPanel(CreatePanel cPanel) {
        setup();
        build();
        this.cPanel = cPanel;
    }

    public void setup() {
        feedBtn.addActionListener(new Listener("feed"));
        backBtn.addActionListener(new Listener("main"));
    }

    public void build() {
        add(feedBtn);
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
