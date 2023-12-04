package UparuMountainGUI.model;

import java.util.concurrent.TimeUnit;


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
    public int getMoneyCapacity() {
        return moneyCapacity;
    }
    public int getUparuCapacity() {
        return uparuCapacity;
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

    public int harvestMoney(Inventory inventory) {
        int producedMoney = calculateProducedMoney();
        showMoneyOutput(producedMoney, inventory);
        updateViews();
        
        return producedMoney;
    }

    private int calculateProducedMoney() {
        int result = totalMoneyOutput();
        if (result > moneyCapacity) {
            result = moneyCapacity;
        }
        return result;
    } 
    public void showMoneyOutput(int producedMoney, Inventory inventory) {
        try {
            TimeUnit.SECONDS.sleep(5);
            inventory.saveMoney(producedMoney);
            updateViews();
        } catch (InterruptedException e) {
            e.printStackTrace();
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