package UparuMountainGUI;

import javax.swing.*;

import java.awt.*;

import UparuMountainGUI.view.FarmPanel;
import UparuMountainGUI.view.FirstMainPanel;
import UparuMountainGUI.view.HabitatPanel;
import UparuMountainGUI.view.HelpPanel;
import UparuMountainGUI.view.InventoryPanel;
import UparuMountainGUI.view.MainPanel;
import UparuMountainGUI.view.RegisterPanel;
import UparuMountainGUI.view.ShopPanel;
import UparuMountainGUI.view.StartPanel;
import UparuMountainGUI.view.UserInfoPanel;


public class UparuMountainWindow extends JFrame{
    public static final int WIDTH = 350, HEIGHT = 600;

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
    }

    public void build() {
        add(createPanel);
    }
    
    public class CreatePanel extends JPanel { 
        private CardLayout card = new CardLayout();

        private StartPanel startPanel = new StartPanel(this);
        private RegisterPanel registerPanel = new RegisterPanel(this);

        private FirstMainPanel firstMainPanel = new FirstMainPanel(this);

        private UserInfoPanel userInfoPanel = new UserInfoPanel(this);
        private HelpPanel helpPanel = new HelpPanel(this);

        private MainPanel mainPanel = new MainPanel(this);
        private HabitatPanel habitatPanel = new HabitatPanel(this);
        private FarmPanel farmPanel = new FarmPanel(this);
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
            add(firstMainPanel, "firstMain");

            add(userInfoPanel, "userInfo");
            add(helpPanel, "help");

            add(mainPanel, "main");
            add(habitatPanel, "habitat");
            add(farmPanel, "farm");
            add(shopPanel, "shop");
            add(inventoryPanel, "inventory");

            card.show(this, "start");
       }

        public CardLayout getCardLayout() {
            return card;
        }

        public MainPanel getMainPanel() {
            return mainPanel;
        }
    }
}
