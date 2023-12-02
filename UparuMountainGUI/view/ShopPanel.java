package UparuMountainGUI.view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

import UparuMountainGUI.UparuMountainWindow;
import UparuMountainGUI.UparuMountainWindow.CreatePanel;
import UparuMountainGUI.controller.NavListener;
import UparuMountainGUI.controller.ShopNavListener;
import UparuMountainGUI.model.Observer;
import UparuMountainGUI.model.Shop;
import UparuMountainGUI.model.User;

public class ShopPanel extends JPanel implements Observer{
    private User user = User.getInstance();
    private CardLayout card = new CardLayout();
    
    private CreatePanel cPanel;
    private Shop shop = new Shop();

    private ShopLobbyPanel shopLobbyPanel;
    private ShopHabitatPanel shopHabitatPanel;
    private ShopUparuPanel shopUparuPanel;
    private ShopFarmPanel shopFarmPanel;
   
    public ShopPanel(CreatePanel cPanel) {
        this.cPanel = cPanel;
        setup();
        build();
        user.attach(this);
        shop.attach(this);
    }

    public void setup() {
        setLayout(card);
        shopLobbyPanel = new ShopLobbyPanel(this);
        shopHabitatPanel = new ShopHabitatPanel(this);
        shopUparuPanel = new ShopUparuPanel(this);
        shopFarmPanel = new ShopFarmPanel(this);

        shop.attach(this);
    }

    public void build() {
        add(shopLobbyPanel, "lobby");
        add(shopHabitatPanel, "habitat");
        add(shopUparuPanel, "uparu");
        add(shopFarmPanel, "farm");

        card.show(this, "lobby");
    }

    @Override
    public void update() {
    }

    public CardLayout getCardLayout() {
        return card;
    }

    private class ShopLobbyPanel extends JPanel {
        private ShopPanel shopPanel;
        private JButton habitatListBtn = new JButton("Habitat");
        private JButton uparuListBtn = new JButton("Uparu");
        private JButton farmListBtn = new JButton("Farm");
        private JButton backBtn = new JButton("Back");


        public ShopLobbyPanel(ShopPanel shopPanel) {
            this.shopPanel = shopPanel;
            setup();
            build();
        }

        private void setup() {
            setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 400));

            habitatListBtn.addActionListener(new ShopNavListener(shopPanel, "habitat"));
            uparuListBtn.addActionListener(new ShopNavListener(shopPanel, "uparu"));
            farmListBtn.addActionListener(new ShopNavListener(shopPanel, "farm"));
            backBtn.addActionListener(new NavListener(cPanel, "main"));
            backBtn.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 200));
        }

        private void build() {
            add(habitatListBtn);
            add(uparuListBtn);
            add(farmListBtn);
            add(backBtn);
        }
    }

    private class ShopHabitatPanel extends JPanel {
        private ShopPanel shopPanel;
        JLabel habitatList = new JLabel("", JLabel.CENTER);
        private JScrollPane scroller = new JScrollPane(habitatList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JLabel warningMsg = new JLabel();
        JTextField field = new JTextField(20);
        JButton purchaseBtn = new JButton("Buy");
        JButton backBtn = new JButton("Back");

        public ShopHabitatPanel(ShopPanel shopPanel) {
            this.shopPanel = shopPanel;
            setup();
            build();
        }

        private void setup() {
            habitatList.setText(shop.getShopHabitats().toString());
            scroller.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 400));

            field.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '6') {
                        field.setEditable(true);
                        warningMsg.setText("");
                    } else {
                        field.setEditable(false);
                        warningMsg.setText("* Enter only numeric digits(1-6)");
                    }
                }
            });
            purchaseBtn.addActionListener(new Listener());
            backBtn.addActionListener(new ShopNavListener(shopPanel, "lobby"));
        }

        private void build() {
            add(scroller);

            add(warningMsg);
            add(field);
            add(purchaseBtn);
            add(backBtn);
        }

        private class Listener implements ActionListener {

            public Listener() {}

            @Override
            public void actionPerformed(ActionEvent e) {
                shop.purchaseHabitat(shop.selectHabitat(Integer.parseInt(field.getText())), user);
                field.setText("");
            }
        }
    }
    private class ShopUparuPanel extends JPanel {
        private ShopPanel shopPanel;
        JLabel uparuList = new JLabel("", JLabel.CENTER);
        private JScrollPane scroller = new JScrollPane(uparuList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        JLabel warningMsg = new JLabel();
        JTextField field = new JTextField(20);
        JButton purchaseBtn = new JButton("Buy");
        JButton backBtn = new JButton("Back");

        public ShopUparuPanel(ShopPanel shopPanel) {
            this.shopPanel = shopPanel;
            setup();
            build();
        }

        private void setup() {
            uparuList.setText(shop.getShopUparus().toString());
            scroller.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 400));
            field.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '6') {
                        field.setEditable(true);
                        warningMsg.setText("");
                    } else {
                        field.setEditable(false);
                        warningMsg.setText("* Enter only numeric digits(1-6)");
                    }
                }
            });
            purchaseBtn.addActionListener(new Listener());
            backBtn.addActionListener(new ShopNavListener(shopPanel, "lobby"));
        }

        private void build() {
            add(scroller);

            add(warningMsg);
            add(field);
            add(purchaseBtn);
            add(backBtn);
        }

        private class Listener implements ActionListener {

            public Listener() {}

            @Override
            public void actionPerformed(ActionEvent e) {
                shop.purchaseUparu(shop.selectUparu(Integer.parseInt(field.getText())), user);
                field.setText("");
            }
        }
    }
    private class ShopFarmPanel extends JPanel {
        private ShopPanel shopPanel;
        JLabel farmList = new JLabel("", JLabel.CENTER);
        private JScrollPane scroller = new JScrollPane(farmList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        JLabel warningMsg = new JLabel();                   
        JTextField field = new JTextField(20);
        JButton purchaseBtn = new JButton("Buy");
        JButton backBtn = new JButton("Back");

        public ShopFarmPanel(ShopPanel shopPanel) {
            this.shopPanel = shopPanel;
            setup();
            build();
        }

        private void setup() {
            farmList.setText(shop.getShopFarms().toString());
            scroller.setPreferredSize(new Dimension(UparuMountainWindow.WIDTH, 400));
            field.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '6') {
                        field.setEditable(true);
                        warningMsg.setText("");
                    } else {
                        field.setEditable(false);
                        warningMsg.setText("* Enter only numeric digits(1-6)");
                    }
                }
            });
            purchaseBtn.addActionListener(new Listener());
            backBtn.addActionListener(new ShopNavListener(shopPanel, "lobby"));
        }

        private void build() {
            add(scroller);

            add(warningMsg);
            add(field);
            add(purchaseBtn);
            add(backBtn);
        }

        private class Listener implements ActionListener {

            public Listener() {}

            @Override
            public void actionPerformed(ActionEvent e) {
                shop.purchaseFarm(shop.selectFarm(Integer.parseInt(field.getText())), user);
                field.setText("");
            }
        }
    }
}
