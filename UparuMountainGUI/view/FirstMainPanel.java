package UparuMountainGUI.view;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import UparuMountainGUI.UparuMountainWindow;
import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.controller.NavListener;
import UparuMountainGUI.model.Observer;
import UparuMountainGUI.model.User;

public class FirstMainPanel extends JPanel{
    private TopPanel topPanel;
    private CenterPanel centerPanel;
    private CreatePanel cPanel;
    private User user = User.getInstance();

    private JButton habitatBtn = new JButton("Habitat");
    private JButton farmBtn = new JButton("Farm");
    private JButton inventoryBtn = new JButton("Inventory");
    private JButton shopBtn = new JButton("Shop");

    public FirstMainPanel(CreatePanel cPanel) {
        this.cPanel = cPanel;
        setup();
        build();
    }

    public void setup() {
        topPanel = new TopPanel(cPanel);
        topPanel.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 100));
        centerPanel = new CenterPanel();
        centerPanel.setBorder(new EmptyBorder(0, 40, 0, 40));
        centerPanel.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 350));
        habitatBtn.addActionListener(new NavListener(cPanel, "habitat"));
        farmBtn.addActionListener(new NavListener(cPanel, "farm"));
        inventoryBtn.addActionListener(new NavListener(cPanel, "inventory"));
        shopBtn.addActionListener(new NavListener(cPanel, "shop"));
    }

    public void build() {
        add(topPanel);
        add(centerPanel);
        add(habitatBtn);
        add(farmBtn);
        add(inventoryBtn);
        add(shopBtn);
    }

    public User getUser() {
        return user;
    }

    private class TopPanel extends JPanel {
        private CreatePanel cPanel;

        private JButton userInfoBtn = new JButton("User Info");
        private JButton helpBtn = new JButton("Help");
        private JButton exitBtn = new JButton("Exit");

        TopPanel(CreatePanel cPanel) {
            this.cPanel = cPanel;
            setup();
            build();
        }

        private void setup() {
            userInfoBtn.addActionListener(new NavListener(this.cPanel, "userInfo"));
            helpBtn.addActionListener(new NavListener(this.cPanel, "help"));
            exitBtn.addActionListener(e -> System.exit(0));
        }

        private void build() {
            add(userInfoBtn);
            add(helpBtn);
            add(exitBtn);
        }
    }

    private class CenterPanel extends JPanel implements Observer{
        private JLabel greetingLabel = new JLabel();

        CenterPanel() {
            setup();
            build();
        }

        private void setup() {
            user.attach(this);
        }

        private void build() {
            add(greetingLabel);
        }

        @Override
        public void update() {
            greetingLabel.setText("<html><p style='text-align:center;'>Hi, " + user.getName() + ". Here you are! <br>I give you an inventory. <br>There are 100 money and 100 fruits in this inventory.</p></html>");
        }
    }
}