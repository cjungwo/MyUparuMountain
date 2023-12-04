package UparuMountainGUI.view;

import javax.swing.*;

import java.awt.Dimension;

import UparuMountainGUI.UparuMountainWindow;
import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.controller.NavListener;
import UparuMountainGUI.model.Observer;
import UparuMountainGUI.model.User;

public class InventoryPanel extends JPanel implements Observer{
    private CreatePanel cPanel;   
    private User user = User.getInstance();

    private JLabel inventoryLabel = new JLabel("", JLabel.CENTER);
    private JScrollPane scroller = new JScrollPane(inventoryLabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private JButton backBtn = new JButton("Back");

    public InventoryPanel(CreatePanel cPanel) {
        this.cPanel = cPanel;
        user.getInventory().attach(this);
        setup();
        build();
    }

    public void setup() {
        inventoryLabel.setText(user.getInventory().toString());
        scroller.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 400));

        backBtn.addActionListener(new NavListener(cPanel, "main"));
    }

    public void build() {
        add(scroller);
        add(backBtn);
    }

    @Override
    public void update() {
        inventoryLabel.setText(user.getInventory().toString());
    }
}
