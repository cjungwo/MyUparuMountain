package UparuMountainGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import UparuMountainGUI.model.Observer;
import UparuMountainGUI.view.FarmPanel;
import UparuMountainGUI.view.HabitatPanel;
import UparuMountainGUI.view.InventoryPanel;
import UparuMountainGUI.view.MainPanel;
import UparuMountainGUI.view.RegisterPanel;
import UparuMountainGUI.view.ShopPanel;
import UparuMountainGUI.view.StartPanel;
import UparuMountainGUI.view.UparuPanel;


public class UparuMountainWindow extends JFrame{
    private final int WIDTH = 350, HEIGHT = 600;

    private CreatePanel createPanel = new CreatePanel();

    public UparuMountainWindow() {
        super("Uparu Mountain");
        setup();
        build();
        setVisible(true);
    }

    public void setup() {
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        createPanel.setBorder(new EmptyBorder(5,5,5,5));
    }

    public void build() {
        add(createPanel);
    }

    public class CreatePanel extends JPanel implements Observer{ 
        private CardLayout card = new CardLayout();

        private StartPanel startPanel = new StartPanel(this);
        private RegisterPanel registerPanel = new RegisterPanel(this);
        private MainPanel mainPanel = new MainPanel(this);
        private HabitatPanel habitatPanel = new HabitatPanel(this);
        private FarmPanel farmPanel = new FarmPanel(this);
        private UparuPanel uparuPanel = new UparuPanel(this);
        private ShopPanel shopPanel = new ShopPanel(this);
        private InventoryPanel inventoryPanel = new InventoryPanel(this);


        public CreatePanel() {
            setup();
            build();
        }
        private void setup() {
            setLayout(card);
        }
        private void build() {
            add(startPanel, "start");
            add(registerPanel, "register");
            add(mainPanel, "main");
            add(habitatPanel, "habitat");
            add(farmPanel, "farm");
            add(uparuPanel, "uparu");
            add(shopPanel, "shop");
            add(inventoryPanel, "inventory");

            card.show(this, "start");
       }

        @Override
        public void update() {
        }

        public CardLayout getCardLayout() {
            return card;
        }
    }
}
