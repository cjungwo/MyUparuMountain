package UparuMountainGUI.model;

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
        updateViews();
    }

    public String eatFruit(Inventory inventory, int fruitsToUse) {
        String result = "<html><p style='text-align:center'>";
        if (inventory.getFruit() >= fruitsToUse) {
            if (inventory.consumeFruit(fruitsToUse)) {
                eatenFruitNum += fruitsToUse;
                result += name + " ate " + fruitsToUse + " fruits.";
                updateViews();
            }
            result += levelUp();
            result += "<br>" + name + "'s total eaten fruits are " + eatenFruitNum;
        } else {
            result += "You have only " + inventory.getFruit() + " fruits.";
        }
        result += "</p></html>";
        return result;
    }
    private String levelUp() {
        String result = "";
        boolean stop = false;
        do {
            if (fruitsPerLevels.getFirst() <= eatenFruitNum) {
                level++;
                result += "<br>Level up!!";
                result += "<br>Now this " + name + " is Level" + level;
                fruitsPerLevels.removeFirst();
                updateViews();
            } else {
                stop = true;
            }
        } while (!stop);
        return result;
    }

    public String toString() {
        return "-------------------------"+
         "<br>Property: " + property +
         "<br>Uparu Name: " + name +
         "<br>Level: " + level + 
         "<br>Eaten Fruit Num: " + eatenFruitNum +
         "<br>Money Output: " + moneyPerSecond + "/5sec" +
         "<br>Price: " + price +
         "<br>-------------------------";
    }
}
