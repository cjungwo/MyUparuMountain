package UparuMountainGame;

import java.util.concurrent.TimeUnit;

public class Farm {
    private String fruitName;
    private int producingTime;
    private int producingAmount;
    private int price;

    public Farm(String fruitName, int producingTime, int producingAmount, int price) {
        this.fruitName = fruitName;
        this.producingTime = producingTime;
        this.producingAmount = producingAmount;
        this.price = price;
    }

    //Getter
    public String getFruitName() {
        return fruitName;
    }
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public String toString() {
        return "-------------------------" +
        "\nFruit Name: " + fruitName +
        "\nProduce Time: " + producingTime + "sec" +
        "\nProducing Amount: " + producingAmount +
        "\nPrice: " + price +
        "\n-------------------------";
    }
}
