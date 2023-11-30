package UparuMountainGUI.model;

public class Inventory {
    int money;
    int fruit;

    public Inventory() {
        money = 100;
        fruit = 100;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getFruit() {
        return fruit;
    }

    public void setFruit(int fruit) {
        this.fruit = fruit;
    }
    
    public void saveMoney(double producedMoney) {
        money += producedMoney;
    }

    public void saveFruit(int producedFruitNum) {
        fruit += producedFruitNum;
    }

    public void consumeMoney(double price) {
        money -= price;
    }

    public boolean consumeFruit(int fruitsToUse) {
        boolean result = false;
        if (checkFruitsNumber(fruitsToUse)) {
            fruit -= fruitsToUse;
            result = true;
        } else {
            System.out.println("You don't have enough fruits.");
        }
        return result;
    }
    private boolean checkFruitsNumber(int fruitsToUse) {
        boolean result = false;
        if (fruit >= fruitsToUse) {
            result = true;
        }
        return result;
    }

    public String toString() {
        return 
        "<html><p>-------------------------" +
        "<br>Inventory" + 
        "<br>-------------------------" +
        "<br>Total Money: " + money + 
        "<br>Total Fruit: " + fruit +
        "<br>-------------------------</p><html>";
    }
}
