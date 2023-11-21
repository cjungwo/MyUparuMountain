package UparuMountainGame;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Habitat {
    private Property property;
    private int moneyCapacity;
    private int uparuCapacity;
    private int price;
    private LinkedList<Uparu> uparusInHabitat = new LinkedList<Uparu>();

    public Habitat(Property property, int moneyCapacity, int uparuCapacity, int price) {
        this.property = property;
        this.moneyCapacity = moneyCapacity;
        this.uparuCapacity = uparuCapacity;
        this.price = price;
    }

    // Getter
    public String getHabitatName() {
        return property + " habitat";
    }

     public Property getProperty() {
        return property;
    }

    public int getPrice() {
        return price;
    }

    public String showUparusInHabitat() {
        return In.showList("Uparu", uparusInHabitat);
    }


    public void addUparu(Uparu uparu) {
        // 리스트에 우파루 추가
        uparusInHabitat.add(uparu);
    }
    public boolean checkHabitatSize() {
        boolean result = false;
        if (uparusInHabitat.size() < uparuCapacity) {
            result = true;
        }
        return result;
    }

    public void feedUparu(Inventory inventory) {
        Uparu selectedUparu = selectUparu();
        if (selectedUparu != null) {
            selectedUparu.eatFruit(inventory);
        } else {
            System.out.println("You do not select any uparu");
        }
    }
    private Uparu selectUparu() {
        Uparu result = null;
        int selection = In.readInt("Select number of uparu for feeding") - 1;
        if (selection < uparusInHabitat.size() && selection >= 0) {
            result = uparusInHabitat.get(selection);
            System.out.println("Your choice is " + result.getName() + ".");
        }
        return result;
    }

    private double totalMoneyOutput() {
        double totalMoneyPerSecond = 0;
        for(Uparu uparu : uparusInHabitat) {
            totalMoneyPerSecond += uparu.getMoneyPerSecond();
        }
        return totalMoneyPerSecond;
    }

    public void harvestMoney(Inventory inventory) {
        double producedMoney = calculateProducedMoney();

        System.out.println("The accumulated money so far is " + producedMoney);
        showMoneyOutput(producedMoney, inventory);
    }
    private double calculateProducedMoney() {
        double result = 0;
        for (Uparu uparu : uparusInHabitat) {
            result += uparu.getMoneyPerSecond();
        }
        if (result > moneyCapacity) {
            result = moneyCapacity;
        }
        return result;
    } 
    private void showMoneyOutput(double producedMoney, Inventory inventory) {
        System.out.println("Do you harvest? (Y/N)");
        char answer = In.nextUpperChar();
        if (answer == 'Y') {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Succeed producing Money.");
                inventory.saveMoney(producedMoney);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String toString() {
        return "--------------------------"+
         "\nProperty: " + property +
         "\nUparu Capacity: " + uparuCapacity +
         "\nTotal Money Capacity: " + moneyCapacity + 
         "\nPrice: " + price +
         "\nUparus In here: \n" + showUparusInHabitat() +
         "\nTotal Harvest money: " + totalMoneyOutput() + "/5sec" +
         "\n---------------------------";
    }
}