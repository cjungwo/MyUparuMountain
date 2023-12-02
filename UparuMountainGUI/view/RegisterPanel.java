package UparuMountainGUI.view;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.*;

import UparuMountainGUI.UparuMountainWindow;
import UparuMountainGUI.UparuMountainWindow.CreatePanel;

public class RegisterPanel extends JPanel{
    private JLabel welcomeMsg = new JLabel("<html><p style='text-align:center;'>Welcome to Uparu Mountain!!<br>What is your name?<p></html> ");
    private JLabel warningLabel = new JLabel();
    private JTextField nameField = new JTextField(15);
    private JButton submitBtn = new JButton("submit");
    private CreatePanel cPanel;

    public RegisterPanel(CreatePanel cPanel) {
        setup();
        build();
        this.cPanel = cPanel;
    }

    private void setup() {
        welcomeMsg.setHorizontalAlignment(JLabel.CENTER);
        welcomeMsg.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 450));
        submitBtn.addActionListener(new ButtonListener());
    }
    
    private void build() {
        add(welcomeMsg);
        add(warningLabel);
        add(nameField);
        add(submitBtn);
    }
    
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(nameField.getText().equals("")) {
                warningLabel.setText("Enter name first!!");
            } else {
                cPanel.getCardLayout().show(cPanel, "firstMain");
                cPanel.getMainPanel().getUser().set(1, nameField.getText());
            }
        }
    }
}
