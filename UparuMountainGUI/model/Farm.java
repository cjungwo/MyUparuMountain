package UparuMountainGUI.model;

import java.util.concurrent.TimeUnit;

public class Farm extends Record{
    private int producingTime;
    private int producingAmount;
    private int price;

    public Farm(int id, String name, int producingTime, int producingAmount, int price) {
        super(id, name);
        this.producingTime = producingTime;
        this.producingAmount = producingAmount;
        this.price = price;
    }

    //Getter
    public int getProducingTime() {
        return producingTime;
    }
    public int getPrice() {
        return price;
    }

    public void harvestFruit(Inventory inventory) {
        try {
            TimeUnit.SECONDS.sleep(producingTime);
            System.out.println("Succeed producing Fruit.");
            inventory.saveFruit(producingAmount);
            updateViews();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public String toString() {
        return "-------------------------" +
        "<br>Fruit Name: " + name +
        "<br>Produce Time: " + producingTime + "sec" +
        "<br>Producing Amount: " + producingAmount +
        "<br>Price: " + price +
        "<br>-------------------------";
    }
}
