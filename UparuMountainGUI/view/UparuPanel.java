package UparuMountainGUI.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import UparuMountainGUI.UparuMountainWindow;
import UparuMountainGUI.controller.HabitatNavListener;
import UparuMountainGUI.controller.NumberInputListener;
import UparuMountainGUI.model.Habitat;
import UparuMountainGUI.model.Observer;
import UparuMountainGUI.model.Uparus;

public class UparuPanel extends JPanel implements Observer {
    private HabitatPanel hPanel;
    private FeedPanel feedPanel;
    private Uparus uparus;

    private JLabel title = new JLabel("", JLabel.CENTER);
    private JLabel listLabel = new JLabel("", JLabel.CENTER);
    private JScrollPane scroller = new JScrollPane(listLabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    private JLabel msgLabel = new JLabel("", JLabel.CENTER);
    private JLabel warningMsg = new JLabel("", JLabel.CENTER);
    private JTextField selelctField = new JTextField(20);
    private JButton selectBtn = new JButton("Select");

    private JButton feedBtn = new JButton("Feed Uparu");       
    private JButton backBtn = new JButton("Back");

    public UparuPanel(HabitatPanel hPanel, FeedPanel feedPanel) {
        this.hPanel = hPanel;
        this.feedPanel = feedPanel;
        setup();
        build();
    }

    public void setHabitat(Habitat habitat) {
        this.uparus = habitat.getUparusInHabitat();
        title.setText(habitat.getName());
        title.setFont(new Font("Arial", Font.PLAIN, 24));
        listLabel.setText(habitat.getUparusInHabitat().toString());
        uparus.attach(this);
        update();
    }

    private void setup() {
        scroller.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 400));
        
        selectBtn.addActionListener(new FeedNavListener());
        feedBtn.addActionListener(new BtnListener());
        backBtn.addActionListener(new HabitatNavListener(hPanel, "lobby"));


        feedBtn.setVisible(false);
        msgLabel.setVisible(false);
        warningMsg.setVisible(false);
        selelctField.setVisible(false);
        selectBtn.setVisible(false);
    }

    private void build() {
        add(title);
        add(scroller);

        add(msgLabel);
        add(warningMsg);
        add(selelctField);
        add(selectBtn);
        add(feedBtn);
        add(backBtn);
    }


    @Override
    public void update() {
        if(uparus.getSize() != 0) {
            feedBtn.setVisible(true);
            listLabel.setText(uparus.toString());
            selelctField.addKeyListener(new NumberInputListener(uparus.getSize(), selelctField, warningMsg));
        }
    }

    private class BtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            msgLabel.setText("Select Uparu to feed fruits");
            msgLabel.setVisible(true);
            warningMsg.setVisible(true);
            selelctField.setVisible(true);
            selectBtn.setVisible(true);
        }
    }

    private class FeedNavListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            feedPanel.setUparu(uparus.find(Integer.parseInt(selelctField.getText())));
            hPanel.getCard().show(hPanel, "feed");
        }
    }
}
