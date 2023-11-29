package UparuMountainGUI.view;

import javax.swing.*;
import java.awt.event.*;

import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.model.Observer;
import UparuMountainGUI.model.User;

public class MainPanel extends JPanel implements Observer{
    private CreatePanel cPanel;
    private User user = new User(1, "Choi");


    private JLabel greetingLabel1 = new JLabel("Hi, " + user.getName() + ".");
     private JLabel greetingLabel2 = new JLabel("Here you are! I give you an inventory.");
    private JLabel greetingLabel3 = new JLabel("There are 100 money and 100 fruits in this inventory.");
   

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
        userInfoBtn.addActionListener(new Listener("userInfo"));
        helpBtn.addActionListener(new Listener("help"));
        exitBtn.addActionListener(e->System.exit(0));
        habitatBtn.addActionListener(new Listener("habitat"));
        farmBtn.addActionListener(new Listener("farm"));
        inventoryBtn.addActionListener(new Listener("inventory"));
        shopBtn.addActionListener(new Listener("shop"));
    }

    public void build() {
        add(userInfoBtn);
        add(helpBtn);
        add(exitBtn);
        add(greetingLabel1);
        add(greetingLabel2);
        add(greetingLabel3);
        add(habitatBtn);
        add(farmBtn);
        add(inventoryBtn);
        add(shopBtn);
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

    public void setUser(User user) {
        this.user = user;
    }
}