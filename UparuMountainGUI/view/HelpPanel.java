package UparuMountainGUI.view;

import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import UparuMountainGUI.UparuMountainWindow;
import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.controller.NavListener;

public class HelpPanel extends JPanel{
    private CreatePanel cPanel;   

    private JLabel helpLabel = new JLabel("Help");
    private JButton backBtn = new JButton("Back");

    public HelpPanel(CreatePanel cPanel) {
        this.cPanel = cPanel;
        setup();
        build();
        
    }

    public void setup() {
        helpLabel.setHorizontalAlignment(JLabel.CENTER);
        helpLabel.setBorder(new EmptyBorder(0, 40, 0, 40));
        helpLabel.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 450));
        helpLabel.setText(
                "<html><p style='text-align:center;'>Welcome to Uparu Mountain!! <br>Buy a habitat with the same property as the Uparu you want to grow using the 100 money and 100 fruits provided and buy a farm, and then you are ready to grow uparus. Now buy and place the uparu you want in your habitat, harvest money through uparus, or harvest fruit in the field to feed uparus and grow up uparus.</p></html>");
        backBtn.addActionListener(new NavListener(cPanel, "main"));
    }

    public void build() {
        add(helpLabel);
        add(backBtn);
    }
}
