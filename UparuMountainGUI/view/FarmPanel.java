package UparuMountainGUI.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import UparuMountainGUI.UparuMountainWindow;
import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.controller.NavListener;
import UparuMountainGUI.model.Observer;
import UparuMountainGUI.model.User;

public class FarmPanel extends JPanel {
    private CreatePanel cPanel;   

    private User user = User.getInstance();
    private CardLayout card = new CardLayout();

    private LobbyPanel lobbyPanel;

    public FarmPanel(CreatePanel cPanel) {
        this.cPanel = cPanel;
        setup();
        build();
    }

    public void setup() {
        setLayout(card);

        lobbyPanel = new LobbyPanel(this);
    }

    public void build() {
        add(lobbyPanel, "lobby");

        card.show(this, "lobby");
    }

    public class FarmNavListener implements ActionListener{
        FarmPanel farmPanel;
        String destination;

        public FarmNavListener(FarmPanel farmPanel, String destination) {
            this.farmPanel = farmPanel;
            this.destination = destination;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            card.show(farmPanel, destination);
        }
    }

    private class LobbyPanel extends JPanel implements Observer{
        private FarmPanel farmPanel;

        private JLabel farmList = new JLabel("", JLabel.CENTER);
        private JScrollPane scroller = new JScrollPane(farmList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        private JButton harvestBtn = new JButton("Harvest Fruit");
        private JButton backBtn = new JButton("Back");

        LobbyPanel(FarmPanel farmPanel) {
            this.farmPanel = farmPanel;
            setup();
            build();
            user.getFarms().attach(this);
        }

        private void setup() {
            farmList.setText(user.getFarms().toString());
            scroller.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 400));

            if (user.getHabitats().getSize() == 0) {
                harvestBtn.setVisible(false);
            }

            harvestBtn.addActionListener(new NavListener(cPanel, "harvestFruit"));
            backBtn.addActionListener(new NavListener(cPanel, "main"));
        }

        private void build() {
            add(scroller);
            add(harvestBtn);
            add(backBtn);
        }

        public void addBuild() {
            
        }

        @Override
        public void update() {
            if (user.getFarms().getSize() != 0) {
                harvestBtn.setVisible(true);
                farmList.setText(user.getFarms().toString());
            }
        }
    }
}
