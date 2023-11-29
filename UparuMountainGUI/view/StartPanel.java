package UparuMountainGUI.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.model.Observer;

public class StartPanel extends JPanel implements Observer{ 
    private CreatePanel cPanel;

    JLabel title = new JLabel("Uparu Mountain");
    JButton startBtn = new JButton("Start");

    public StartPanel(CreatePanel cPanel) {
        setup();
        build();
        this.cPanel = cPanel;
    }
    public void setup() {
        title.setBackground(Color.red);
        title.setSize(WIDTH, 400);

        startBtn.setBackground(Color.green);
        startBtn.setSize(WIDTH, 200);
        startBtn.addActionListener(new Listener());
    }

    public void build() {
        add(title);
        add(startBtn);
    }

    @Override
    public void update() {
    }

    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object ob = e.getSource();
            if (ob == startBtn) {
                cPanel.getCardLayout().show(cPanel, "register");
            }
        }
    }
}
