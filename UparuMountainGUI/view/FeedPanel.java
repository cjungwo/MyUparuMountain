package UparuMountainGUI.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import UparuMountainGUI.UparuMountainWindow;
import UparuMountainGUI.controller.HabitatNavListener;
import UparuMountainGUI.model.Inventory;
import UparuMountainGUI.model.Observer;
import UparuMountainGUI.model.Uparu;
import UparuMountainGUI.model.User;

public class FeedPanel extends JPanel implements Observer {
    private User user = User.getInstance();

    private Uparu uparu;
    private Inventory inventory = user.getInventory();

    private HabitatPanel hPanel;

    private JLabel listLabel = new JLabel("", JLabel.CENTER);
    private JScrollPane scroller = new JScrollPane(listLabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    private JLabel msgLabel = new JLabel("", JLabel.CENTER);
    private JLabel warningMsg = new JLabel("", JLabel.CENTER);
    private JTextField fruitNumField = new JTextField(20);
    private JButton feedBtn = new JButton("Feed");

    private JButton backBtn = new JButton("Back");

    public FeedPanel(HabitatPanel hPanel) {
        this.hPanel = hPanel;
        setup();
        build();
        inventory.attach(this);
    }

    public void setUparu(Uparu uparu) {
        this.uparu = uparu;
        listLabel.setText("<html><p style='text-align:center'>" + uparu.toString() + "</p></html>");
        uparu.attach(this);
        update();
    }

    private void setup() {
        scroller.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 400));

        msgLabel.setText("<html><p style='text-align:center'>How many fruits do you want to feed? <br>You have " + inventory.getFruit() + " fruits.</p></html>");

        feedBtn.addActionListener(new FeedBtnListener());
        backBtn.addActionListener(new HabitatNavListener(hPanel, "lobby"));
    }

    private void build() {
        add(scroller);

        add(msgLabel);
        add(warningMsg);
        add(fruitNumField);
        add(feedBtn);
        add(backBtn);
    }

    @Override
    public void update() {
        if (uparu != null) {
            listLabel.setText("<html><p style='text-align:center'>" + uparu.toString() + "</p></html>");
        }
        msgLabel.setText("<html><p style='text-align:center'>How many fruits do you want to feed? <br>You have " + inventory.getFruit() + " fruits.</p></html>");
    }

    private class FeedBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            msgLabel.setText(uparu.eatFruit(inventory, Integer.parseInt(fruitNumField.getText())));
            fruitNumField.setText("");
        }
    }
}