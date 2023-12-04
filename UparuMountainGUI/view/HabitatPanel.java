package UparuMountainGUI.view;

import java.awt.Dimension;

import javax.swing.*;

import UparuMountainGUI.UparuMountainWindow;
import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.controller.NavListener;
import UparuMountainGUI.model.Observer;
import UparuMountainGUI.model.User;

public class HabitatPanel extends JPanel implements Observer{
    private CreatePanel cPanel;   
    private User user = User.getInstance();

    private JLabel habitatList = new JLabel("", JLabel.CENTER);
    private JScrollPane scroller = new JScrollPane(habitatList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    private JButton showUparuBtn = new JButton("Show Uparu");
    private JButton harvestBtn = new JButton("Harvest Money");
    private JButton backBtn = new JButton("Back");

    public HabitatPanel(CreatePanel cPanel) {
        this.cPanel = cPanel;
        setup();
        build();
        user.getHabitats().attach(this);
    }

    public void setup() {
        habitatList.setText(user.getHabitats().toString());
        scroller.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 400));

        showUparuBtn.addActionListener(new NavListener(cPanel, "uparu"));
        harvestBtn.addActionListener(new NavListener(cPanel, "harvestMoney"));
        backBtn.addActionListener(new NavListener(cPanel, "main"));
    }

    public void build() {
        add(scroller);
        add(showUparuBtn);
        add(harvestBtn);
        add(backBtn);
    }

    @Override
    public void update() {
        habitatList.setText(user.getHabitats().toString());
    }
}
