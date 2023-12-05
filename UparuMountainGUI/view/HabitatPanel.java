package UparuMountainGUI.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import UparuMountainGUI.UparuMountainWindow;
import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.controller.NavListener;
import UparuMountainGUI.controller.NumberInputListener;
import UparuMountainGUI.model.Habitat;
import UparuMountainGUI.model.Observer;
import UparuMountainGUI.model.User;

public class HabitatPanel extends JPanel{
    private CreatePanel cPanel;
    
    private User user = User.getInstance();
    private CardLayout card = new CardLayout();

    
    private LobbyPanel lobbyPanel;
    private UparuPanel uparuPanel;
    private HarvestPanel harvestPanel;
    private FeedPanel feedPanel;

    public HabitatPanel(CreatePanel cPanel) {
        this.cPanel = cPanel;
        setup();
        build();
    }
    
    public void setup() {
        setLayout(card);
        
        lobbyPanel = new LobbyPanel(this);
        feedPanel = new FeedPanel(this);
        uparuPanel = new UparuPanel(this, feedPanel);
        harvestPanel = new HarvestPanel(this, harvestPanel);
    }
    
    public void build() {
        add(lobbyPanel, "lobby");
        add(uparuPanel, "uparu");
        add(harvestPanel, "harvest");
        add(feedPanel, "feed");
        
        card.show(this, "lobby");
    }

    public CardLayout getCard() {
        return card;
    }
    
    private class LobbyPanel extends JPanel implements Observer{
        private HabitatPanel habitatPanel;

        private JLabel listLabel = new JLabel("", JLabel.CENTER);
        private JScrollPane scroller = new JScrollPane(listLabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        private JLabel msgLabel = new JLabel("", JLabel.CENTER);
        private JLabel warningMsg = new JLabel("", JLabel.CENTER);
        private JTextField selectField = new JTextField(20);
        private JButton selectBtn = new JButton("Select");

        private JButton showUparuBtn = new JButton("Show Uparu");
        private JButton harvestBtn = new JButton("Harvest Money");
        private JButton backBtn = new JButton("Back");

        private UparuListener uparuListener = new UparuListener();
        private HarvestListener harvestListener = new HarvestListener();

        public LobbyPanel(HabitatPanel habitatPanel) {
            this.habitatPanel = habitatPanel;
            setup();
            build();
            user.getHabitats().attach(this);
        }

        public void setup() {
            listLabel.setText(user.getHabitats().toString());
            scroller.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 400));

            if (user.getHabitats().getSize() == 0) {
                showUparuBtn.setVisible(false);
                harvestBtn.setVisible(false);
            }

            showUparuBtn.addActionListener(new BtnListener("to show Uparu in Habitat", uparuListener));
            harvestBtn.addActionListener(new BtnListener("for harvest", harvestListener));
            backBtn.addActionListener(new NavListener(cPanel, "main"));

            msgLabel.setVisible(false);
            warningMsg.setVisible(false);
            selectField.setVisible(false);
            selectBtn.setVisible(false);
        }

        public void build() {
            add(scroller);
            add(msgLabel);
            add(warningMsg);
            add(selectField);
            add(selectBtn);
            add(showUparuBtn);
            add(harvestBtn);
            add(backBtn);
        }

        @Override
        public void update() {
            if (user.getHabitats().getSize() != 0) {
                showUparuBtn.setVisible(true);
                harvestBtn.setVisible(true);
                listLabel.setText(user.getHabitats().toString());
                selectField.addKeyListener(new NumberInputListener(user.getHabitats().getSize(), selectField, warningMsg));
            }
        }

        private class BtnListener implements ActionListener {
            String msg;
            ActionListener actionListener;

            BtnListener(String msg, ActionListener actionListener) {
                this.msg = msg;
                this.actionListener = actionListener;
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                msgLabel.setText("Select Habitat " + msg);
                msgLabel.setVisible(true);
                warningMsg.setVisible(true);
                selectField.setVisible(true);
                if (actionListener == uparuListener) {
                    if (selectBtn.getAction() != null) {
                        selectBtn.removeActionListener(harvestListener);
                    } else {
                        selectBtn.addActionListener(actionListener);
                    }
                } else {
                    if (selectBtn.getAction() != null) {
                        selectBtn.removeActionListener(uparuListener);
                    } else {
                        selectBtn.addActionListener(actionListener);
                    }
                }
                selectBtn.setVisible(true);
            }
        }

        private class UparuListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Habitat habitat = (Habitat) user.getHabitats().find(Integer.parseInt(selectField.getText()));

                uparuPanel.setHabitat(habitat);
                selectField.setText("");
                card.show(habitatPanel, "uparu");
            }
        }

        private class HarvestListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Habitat habitat = (Habitat) user.getHabitats().find(Integer.parseInt(selectField.getText()));

                harvestPanel.setHabitat(habitat);
                selectField.setText("");
                card.show(habitatPanel, "harvest");
            }
        }
    }
}