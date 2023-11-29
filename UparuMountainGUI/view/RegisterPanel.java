package UparuMountainGUI.view;

import javax.swing.*;
import java.awt.event.*;

import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.model.Observer;
import UparuMountainGUI.model.User;

public class RegisterPanel extends JPanel implements Observer{
    private User user;
    private JLabel welcomeMsg = new JLabel("Welcome to Uparu Mountain!!");
    private JLabel nameQustion = new JLabel("What is your name?");
    private JLabel warningLabel = new JLabel();
    private JTextField nameField = new JTextField(15);
    private JButton submitBtn = new JButton("submit");
    private CreatePanel cPanel;

    public RegisterPanel(CreatePanel cPanel) {
        submitBtn.addActionListener(new ButtonListener());
        setup();
        build();
        this.cPanel = cPanel;
    }

    private void setup() {
    }
    
    private void build() {
        add(welcomeMsg);
        add(nameQustion);
        add(warningLabel);
        add(nameField);
        add(submitBtn);
    }


    @Override
    public void update() {
        user = new User(0, nameField.getText());
    }
    
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(nameField.getText().equals("")) {
                warningLabel.setText("Enter name first.\n");
            } else {
                cPanel.getCardLayout().show(cPanel, "main");
            }
        }
    }
}
