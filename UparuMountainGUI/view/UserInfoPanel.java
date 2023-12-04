package UparuMountainGUI.view;

import java.awt.Dimension;

import javax.swing.*;

import UparuMountainGUI.UparuMountainWindow;
import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.controller.NavListener;
import UparuMountainGUI.model.Observer;
import UparuMountainGUI.model.User;

public class UserInfoPanel extends JPanel implements Observer{
    private CreatePanel cPanel;
    private User user = User.getInstance();

    private JLabel userInfoLabel = new JLabel("", JLabel.CENTER);
    private JButton backBtn = new JButton("Back");
    private JScrollPane scroller = new JScrollPane(userInfoLabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    public UserInfoPanel(CreatePanel cPanel) {
        this.cPanel = cPanel;
        setup();
        build();
        user.attach(this);
        user.getInventory().attach(this);
        user.getHabitats().attach(this);
        user.getFarms().attach(this);
    }

    private void setup() {
        scroller.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 400));
        backBtn.addActionListener(new NavListener(cPanel, "main"));
    }

    private void build() {
        add(scroller);
        add(backBtn);
    }

    @Override
    public void update() {
        userInfoLabel.setText(user.toString());
    }
}

