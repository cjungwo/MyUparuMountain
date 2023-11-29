package UparuMountainGUI.view;

import javax.swing.*;
import java.awt.event.*;

import UparuMountainGUI.UparuMountainWindow.CreatePanel;
// import UparuMountainGUI.UparuMountain;
import UparuMountainGUI.model.Observer;
import UparuMountainGUI.model.User;

public class MainPanel extends JPanel implements Observer{
    private CreatePanel cPanel;
    // private UparuMountain uparuMountain = new UparuMountain();
    private User user = new User(1, "Choi");


    private JLabel userLabel = new JLabel("Hi, " + user.getName() + ".");
    private JButton userInfoBtn = new JButton("User Info");
    private JButton helpBtn = new JButton("Help");
    private JButton exitBtn = new JButton("Exit");

    private JButton habitatBtn = new JButton("Habitat");
    private JButton farmBtn = new JButton("Farm");
    private JButton inventoryBtn = new JButton("Inventory");
    private JButton shopBtn = new JButton("Shop");

    public MainPanel(CreatePanel cPanel) {
        setup();
        build();
        user.attach(this);
        this.cPanel = cPanel;
    }

    public void setup() {
        userInfoBtn.addActionListener(new Listener());
        helpBtn.addActionListener(new Listener());
        exitBtn.addActionListener(e->System.exit(0));
        habitatBtn.addActionListener(new Listener());
        farmBtn.addActionListener(new Listener());
        inventoryBtn.addActionListener(new Listener());
        shopBtn.addActionListener(new Listener());
    }

    public void build() {
        add(userInfoBtn);
        add(helpBtn);
        add(exitBtn);
        add(userLabel);
        add(habitatBtn);
        add(farmBtn);
        add(inventoryBtn);
        add(shopBtn);
    }

    @Override
    public void update() {
    }

    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            userInfoBtn.setText(user.toString());
        }
    }

    public void setUser(User user) {
        this.user = user;
    }
}