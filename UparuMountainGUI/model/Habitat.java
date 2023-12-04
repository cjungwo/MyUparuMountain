package UparuMountainGUI.model;

import java.util.concurrent.TimeUnit;

import UparuMountainGUI.In;

public class Habitat extends Record{
    private Property property;
    private int moneyCapacity;
    private int uparuCapacity;
    private int price;
    private Uparus uparusInHabitat = new Uparus();

    public Habitat(int id, String name, Property property, int moneyCapacity, int uparuCapacity, int price) {
        super(id, name);
        this.property = property;
        this.moneyCapacity = moneyCapacity;
        this.uparuCapacity = uparuCapacity;
        this.price = price;
    }
    

    // Getter
    public Property getProperty() {
        return property;
    }

    public int getPrice() {
        return price;
    }
    public Uparus getUparusInHabitat() {
        return uparusInHabitat;
    }

    public void addUparu(String name, Property property, int moneyPerSecond, int price) {
        uparusInHabitat.add(name, property, moneyPerSecond, price);
        updateViews();
    }

    public boolean checkHabitatSize() {
        boolean result = false;
        if (uparusInHabitat.getRecords().size() < uparuCapacity) {
            result = true;
        }
        return result;
    }

    private int totalMoneyOutput() {
        int totalMoneyPerSecond = 0;
        for(Record uparu : uparusInHabitat.getRecords()) {
            totalMoneyPerSecond += ((Uparu)uparu).getMoneyPerSecond();
        }
        return totalMoneyPerSecond;
    }

    public void harvestMoney(Inventory inventory) {
        if(!checkEmpty()) {
            int producedMoney = calculateProducedMoney();

            System.out.println("The accumulated money so far is " + producedMoney);
            showMoneyOutput(producedMoney, inventory);
            updateViews();
        }
    }

    public boolean checkEmpty() {
        boolean result;
        if (uparusInHabitat.getRecords().size() == 0) {
            result = true;
            System.out.println("There is any uparu.");
        } else {
            result = false;
        }
        return result;
    }

    private int calculateProducedMoney() {
        int result = totalMoneyOutput();
        if (result > moneyCapacity) {
            result = moneyCapacity;
        }
        return result;
    } 
    private void showMoneyOutput(double producedMoney, Inventory inventory) {
        System.out.println("Do you harvest? It takes 5sec. (Y/N)");
        char answer = In.nextUpperChar();
        if (answer == 'Y') {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Succeed producing Money.");
                inventory.saveMoney(producedMoney);
                updateViews();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String toString() {
        return "--------------------------"+
         "<br>Property: " + property +
         "<br>Uparu Capacity: " + uparuCapacity +
         "<br>Total Money Capacity: " + moneyCapacity + 
         "<br>Price: " + price +
        //  "<br>Uparus In here: <br>" + showUparusInHabitat() +
         "<br>Total Harvest money: " + totalMoneyOutput() + "/5sec" +
         "<br>---------------------------";
    }
    
    public String showUparusInHabitat() {
        return uparusInHabitat.toString();
    }
}