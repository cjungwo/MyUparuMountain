package UparuMountainGUI.view;

import java.awt.Dimension;

import javax.swing.*;

import UparuMountainGUI.UparuMountainWindow;
import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.controller.NavListener;
import UparuMountainGUI.model.Observer;
import UparuMountainGUI.model.User;

public class FarmPanel extends JPanel implements Observer{
    private CreatePanel cPanel;   
    private User user = User.getInstance();

    private JLabel farmList = new JLabel("", JLabel.CENTER);
    private JScrollPane scroller = new JScrollPane(farmList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    private JButton harvestBtn = new JButton("Harvest Fruit");
    private JButton backBtn = new JButton("Back");

    public FarmPanel(CreatePanel cPanel) {
        this.cPanel = cPanel;
        setup();
        build();
        user.getFarms().attach(this);
    }

    public void setup() {
        farmList.setText(user.getFarms().toString());
        scroller.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 400));

        harvestBtn.addActionListener(new NavListener(cPanel, "harvestFruit"));
        backBtn.addActionListener(new NavListener(cPanel, "main"));
    }

    public void build() {
        add(scroller);
        add(harvestBtn);
        add(backBtn);
    }

    @Override
    public void update() {
        farmList.setText(user.getFarms().toString());
    }
}
