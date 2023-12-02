package UparuMountainGUI.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UparuMountainGUI.view.ShopPanel;

public class ShopNavListener implements ActionListener {
    ShopPanel shopPanel;
    String destination;

    public ShopNavListener(ShopPanel shopPanel, String destination) {
        this.shopPanel = shopPanel;
        this.destination = destination;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        shopPanel.getCardLayout().show(shopPanel, destination);
    }
}