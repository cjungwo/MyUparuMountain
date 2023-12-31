package UparuMountainGame;

import java.util.LinkedList;

public class Uparu extends Record{
    protected int level = 1;
    protected Property property;
    protected int moneyPerSecond;
    protected int price;
    protected int eatenFruitNum = 0;

    private LinkedList<Integer> fruitsPerLevels = new LinkedList<Integer>();
    

    public Uparu(int id, String name, Property property, int moneyPerSecond, int price) {
        super(id, name);
        this.property = property;
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
    public int getLevel() {
        return level;
    }
    public Property getProperty() {
        return property;
    }
    public int getMoneyPerSecond() {
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
        System.out.println("This " + name + " need to "
                + (fruitsPerLevels.getFirst() - eatenFruitNum)
                + "fruits for level up");
        int fruitsToUse = In.readInt("How many fruits would you feed this Uparu? \nTotal "
                + inventory.getFruit() + "fruits");
        if (inventory.consumeFruit(fruitsToUse)) {
            eatenFruitNum += fruitsToUse;
            System.out.println(name + " ate " + fruitsToUse + "fruits.");
        }
        levelUp();
        System.out.println(name + "'s total eaten fruits are " + eatenFruitNum);
    }
    private void levelUp() {
        boolean stop = false;
        do {
            if (fruitsPerLevels.getFirst() <= eatenFruitNum) {
                level++;
                System.out.println("Level up!!");
                System.out.println("Now this " + name + " is Level" + level);
                fruitsPerLevels.removeFirst();
            } else {
                stop = true;
            }
        } while (!stop);
    }

    public String toString() {
        return "-------------------------"+
         "\nProperty: " + property +
         "\nUparu Name: " + name +
         "\nLevel: " + level + 
         "\nEaten Fruit Num: " + eatenFruitNum +
         "\nMoney Output: " + moneyPerSecond + "/5sec" +
         "\nPrice: " + price +
         "\n-------------------------";
    }
}
