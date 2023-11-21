package UparuMountainGame;

public class UparuMountain {
    private Uparus uparus = Uparus.getUparus();
    private Habitats habitats = Habitats.getHabitats(); 
    private Farms farms = Farms.getFarms();
    private Inventory inventory = Inventory.getInventory();
    private Shop shop = Shop.getShop();

    private boolean stop = false;

    public UparuMountain() {
        System.out.println("Welcome to Uparu Mountain!!");
        System.out.println("Here! I give you an inventory. \nThere are 100 money and 100 fruits in this inventory.");
        while (!stop) {
            menu();
        }
    }

    private void menu() { 
        int action = readAction();
        switch (action) {
            case 1:
                habitats.menu();
                break;
            case 2:
                farms.menu();
                break;
            case 3:
                uparus.menu();
                break;
            case 4:
                showInventory();
                break;
            case 5:
                goToShop();
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
        return In.readInt("Please Enter your choice (1. Show Habitats 2. Show Farms 3. Show All Uparus 4. Show Inventory 5. Go to shop 6. exit 7. help)");
    }

    private void showInventory() {
        System.out.println(inventory.toString());
    }

    private void goToShop() {
        System.out.println(shop.toString());
        shop.select();
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
        System.out.println("");
    }
}