package UparuMountainGUI;

import javax.swing.*;
import java.awt.event.*;

import UparuMountainGUI.model.Observer;
import UparuMountainGUI.model.User;


public class UparuMountainWindow extends JFrame{
    private MainPanel mainPanel = new MainPanel();

    public UparuMountainWindow() {
        super("Uparu Mountain");
        setup();
        build();
        setVisible(true);
    }

    public void setup() {
        setBounds(0, 0, 300, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void build() {
        add(mainPanel);
    }

    private class MainPanel extends JPanel implements Observer{ 
        User user = new User(1, "choi");
        Listener listener = new Listener();
        public MainPanel() {
            setup();
            build();
            user.attach(this);
        }

        public void setup() {

        }

        public void build() {

        }

        @Override
        public void update() {
        }

        private class Listener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

            }

        }
    }

}
