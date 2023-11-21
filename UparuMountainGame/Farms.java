package UparuMountainGame;

import java.util.LinkedList;

public class Farms {
    private static Farms farms;
    private LinkedList<Farm> farmList;

    public Farms() {
        farmList = new LinkedList<Farm>();
    }

    public static Farms getFarms() {
        if (farms == null) {
            synchronized (Farms.class) {
                farms = new Farms();
            }
        }
        return farms;
    }

    public void setFarm(Farm farm) {
        farmList.add(farm);
    }

    public void menu() {
        showFarms();
        if (farmList.size() != 0) {
            int action = readAction();
            switch (action) {
                case 1:
                    harvest();
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
                "Please Enter your choice (1. Harvest fruits 2. Exit)");
    }

    private void harvest() {
        Farm selectFarm = selectFarm();
        if (selectFarm != null) {
            selectFarm.harvestFruit(Inventory.getInventory());
        } else {
            System.out.println("You select wrong number of Farm.");
        }
    }
    private Farm selectFarm() {
        Farm result = null;
        int selection = In.readInt("Which one do you like?") - 1;
        if (selection < farmList.size() && selection >= 0) {
            result = farmList.get(selection);
            System.out.println("Your choice is " + result.getFruitName() + " farm.");
        }
        return result;
    }

    public void showFarms() {
        System.out.println(In.showList("Farm", farmList));
    }
}
