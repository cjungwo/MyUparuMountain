package UparuMountainGame;

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

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void harvestFruit(Inventory inventory) {
        try {
            TimeUnit.SECONDS.sleep(producingTime);
            System.out.println("Succeed producing Fruit.");
            inventory.saveFruit(producingAmount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public String toString() {
        return "-------------------------" +
        "\nFruit Name: " + name +
        "\nProduce Time: " + producingTime + "sec" +
        "\nProducing Amount: " + producingAmount +
        "\nPrice: " + price +
        "\n-------------------------";
    }
}
