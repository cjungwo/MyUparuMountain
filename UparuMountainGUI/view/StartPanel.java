package UparuMountainGUI.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import UparuMountainGUI.UparuMountainWindow;
import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.model.Observer;

public class StartPanel extends JPanel implements Observer{ 
    private CreatePanel cPanel;

    JLabel title = new JLabel("Uparu Mountain", JLabel.CENTER);
    JButton startBtn = new JButton("Start");

    public StartPanel(CreatePanel cPanel) {
        this.cPanel = cPanel;
        setup();
        build();
    }
    public void setup() {
        setLayout(new FlowLayout());
        title.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 400));
        title.setFont(new Font(Font.SERIF, Font.BOLD, 20));

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
