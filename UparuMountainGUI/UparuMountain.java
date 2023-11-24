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
        user = new User(0, name);
        System.out.println("Hi, " + name + "!");
        System.out.println("Here you are! I give you an inventory. \nThere are 100 money and 100 fruits in this inventory.");
        while (!stop) {
            menu();
        }
    }

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
        String result = "Welcome to Uparu Mountain!!\nBuy a habitat with the same property as the Uparu you want to grow \nusing the 100 money and 100 fruits provided \nand buy a farm, and then you are ready to grow uparus. \nNow buy and place the uparu you want in your habitat, \nharvest money through uparus, or harvest fruit in the field to feed uparus \nand grow up uparus.";
        System.out.println(result);
    }
}