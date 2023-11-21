package UparuMountainGame;

import java.util.LinkedList;

public class Uparus {
    private static Uparus uparus;
    LinkedList<Uparu> uparuList;

    public Uparus() {
        uparuList = new LinkedList<Uparu>();
    }

    public static Uparus getUparus() {
        if (uparus == null) {
            synchronized (Uparus.class) {
                uparus = new Uparus();
            }
        }
        return uparus;
    }

    public int getSize() {
        return uparuList.size();
    }

    public void setUparu(Uparu uparu) {
        uparuList.add(uparu);
    }

    public void menu() {
        showUparus();
        if (uparuList.size() != 0) {
            int action = readAction();
            switch (action) {
                case 1:
                    feed();
                    break;
                case 2:
                    System.out.println("Go back to main menu.");
                    break;
                default:
                    System.out.println("You chose wrong number.");
                    break;
            }
        }
    }
    private int readAction() {
        return In.readInt(
                "Enter your choice (1. Feeding Uparu 2. Exit)");
    }

    private void feed() {
        Uparu selectUparu = selectUparu();
        if (selectUparu != null) {
            selectUparu.eatFruit(Inventory.getInventory());
        } else {
            System.out.println("You select wrong number of uparu.");
        }
    }
    private Uparu selectUparu() {
        Uparu result = null;
        int selection = In.readInt("Select number of uparu for feeding") - 1;
        if (selection < uparuList.size() && selection >= 0) {
            result = uparuList.get(selection);
            System.out.println("Your choice is " + result.getName() + ".");
        }
        return result;
    }

    public void showUparus() {
        System.out.println(In.showList("Uparu", uparuList));
    }
}
