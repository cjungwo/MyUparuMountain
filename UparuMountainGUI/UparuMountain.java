package UparuMountainGUI;

import UparuMountainGUI.model.Shop;
import UparuMountainGUI.model.User;

public class UparuMountain {
    private User user;
    private Shop shop = new Shop();

    private boolean stop = false;

    public UparuMountain() {
        System.out.println("Welcome to Uparu Mountain!!");
        System.out.println("What is your name?");
        String name = In.nextLine();
        user = User.getInstance();
        System.out.println("Hi, " + name + "!");
        System.out.println("Here you are! I give you an inventory. <br>There are 100 money and 100 fruits in this inventory.");
        while (!stop) {
            menu();
        }
    }
// complete
    private void menu() { 
        int action = readAction();
        switch (action) {
            case 1:
                user.showHabitats();
                break;
            case 2:
                user.showFarms();
                break;
            case 3:
                showInventory();
                break;
            case 4:
                purchase();
                break;
            case 5:
                userInfo();
                break;
            case 6:
                exit();
                break;
            case 7:
                help();
                break;
            default:
                System.out.println("You chose wrong number.");
                break;
        }
    }
    private int readAction() {
        String menuString = "Please Enter your choice (1. Show Habitats 2. Show Farms 3. Show Inventory 4. Purchase 5. User Info 6. Exit 7. Help)";
        return In.readInt(menuString);
    }
// complete
    private void showInventory() {
        System.out.println(user.getInventory().toString());
    }

    private void purchase() {
        shop.menu(user);
    }

    private void userInfo() {
        System.out.println(user.toString());
    }

    private void exit() {
        System.out.println("This game can not save.");
        System.out.println("Are you really exit? (Y/N)");
        if (In.nextUpperChar() == 'Y') {
            stop = true;
            System.out.println("See you again~~!");
        } else {
            System.out.println("Good choice!");
        }
    }

    private void help() {
        // 게임 도움말 참고해서 추가하기
        String result = "Welcome to Uparu Mountain!!<br>Buy a habitat with the same property as the Uparu you want to grow <br>using the 100 money and 100 fruits provided <br>and buy a farm, and then you are ready to grow uparus. <br>Now buy and place the uparu you want in your habitat, <br>harvest money through uparus, or harvest fruit in the field to feed uparus <br>and grow up uparus.";
        System.out.println(result);
    }
}