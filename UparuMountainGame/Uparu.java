package UparuMountainGame;

import java.util.LinkedList;

public class Uparu {
    protected String name;
    protected int level = 1;
    protected Property property;
    protected double moneyPerSecond;
    protected int price;
    protected int eatenFruitNum = 0;

    private LinkedList<Integer> fruitsPerLevels = new LinkedList<Integer>();

    public Uparu(String name, double moneyPerSecond, int price) {
        this.name = name;
        this.property = Property.Normal;
        this.moneyPerSecond = moneyPerSecond;
        this.price = price;
        setfruitsPerLevels();
    }
    private void setfruitsPerLevels() {
        fruitsPerLevels.add(50);
        fruitsPerLevels.add(100);
        fruitsPerLevels.add(200);
        fruitsPerLevels.add(400);
        fruitsPerLevels.add(800);
        fruitsPerLevels.add(1600);
        fruitsPerLevels.add(3200);
        fruitsPerLevels.add(6400);
        fruitsPerLevels.add(12800);
    }

    // Getter
    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public Property getProperty() {
        return property;
    }
    public double getMoneyPerSecond() {
        return moneyPerSecond;
    }
    public int getPrice() {
        return price;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void eatFruit(Inventory inventory) {
        System.out.println("You have " + inventory.getFruit() + "fruits.");
        int fruitsToUse = In.readInt("How many fruits would you feed this Uparu?");
        if (inventory.consumeFruit(fruitsToUse)) {
            eatenFruitNum += fruitsToUse;
            System.out.println(name + " ate " + fruitsToUse + "fruits.");
        }
        if (fruitsPerLevels.getFirst() == eatenFruitNum) {
            levelUp();
            fruitsPerLevels.removeFirst();
        }
    }
    private void levelUp() {
        level++;
        System.out.println("Level up!!");
    }

    public String toString() {
        return "-------------------------"+
         "\nProperty: " + property +
         "\nUparu Name: " + name +
         "\nLevel: " + level + 
         "\nEaten Fruit Num: " + eatenFruitNum +
         "\nMoney Output: " + moneyPerSecond + "/5sec" +
         "\nPrice: " + price;
    }
}
