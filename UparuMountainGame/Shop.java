package UparuMountainGame;

import java.util.LinkedList;

public class Shop {
    private static Shop shop;

    private LinkedList<Uparu> shopUparus = new LinkedList<Uparu>();
    private LinkedList<Habitat> shopHabitats = new LinkedList<Habitat>();
    private LinkedList<Farm> shopFarms = new LinkedList<Farm>();

    private Inventory inventory = Inventory.getInventory();
    private Uparus uparus = Uparus.getUparus();
    private Habitats habitats = Habitats.getHabitats();
    private Farms farms = Farms.getFarms();

    public Shop() {
        setShopUparu();
        setShopHabitat();
        setShopFarms();
    }

    public static Shop getShop() {
        if (shop == null) {
            synchronized (Shop.class) {
                shop = new Shop();
            }
        }
        return shop;
    }

    // setting
    private void setShopUparu() {
        shopUparus.add(new PlantUparu("uparu1", 10, 10));
        shopUparus.add(new FireUparu("uparu2", 20, 30));
        shopUparus.add(new WaterUparu("uparu3", 16, 50));
        shopUparus.add(new EarthUparu("uparu4", 13, 100));
        shopUparus.add(new WindUparu("uparu5", 17, 200));
        shopUparus.add(new IceUparu("uparu6", 15, 500));
    }

    private void setShopHabitat() {
        shopHabitats.add(new Habitat(Property.Plant, 1000, 3, 10));
        shopHabitats.add(new Habitat(Property.Fire, 10000, 4, 30));
        shopHabitats.add(new Habitat(Property.Earth, 6000, 3, 100));
        shopHabitats.add(new Habitat(Property.Water, 30000, 4, 400));
        shopHabitats.add(new Habitat(Property.Wind, 16000, 4, 800));
        shopHabitats.add(new Habitat(Property.Ice, 8000, 3, 1200));
    }

    private void setShopFarms() {
        shopFarms.add(new Farm("Strawberry", 1, 10, 10));
        shopFarms.add(new Farm("Apple", 2, 50, 50));
        shopFarms.add(new Farm("Banana", 3, 100, 200));
        shopFarms.add(new Farm("Peach", 4, 120, 500));
        shopFarms.add(new Farm("Cherry", 5, 150, 2000));
        shopFarms.add(new Farm("WaterMelon", 6, 300, 2500));
    }

    // Getter
    private void getShopUparus() {
        System.out.println(In.showList("Uparu", shopUparus));
    }

    private void getShopHabitats() {
        System.out.println(In.showList("Habitat", shopHabitats));
    }

    private void getShopFarms() {
        System.out.println(In.showList("Farm", shopFarms));
    }

    public void select() {
        int selection = In.readInt("Select Number");
        Object result;
        switch (selection) {
            case 1:
                result = selectUparu();
                if (result != null) {
                    purchaseUparu((Uparu) result);
                } else {
                    System.out.println("You chose wrong number.");
                }
                break;
            case 2:
                result = selectHabitat();
                if (result != null) {
                    purchaseHabitat((Habitat) result);
                } else {
                    System.out.println("You chose wrong number.");
                }
                break;
            case 3:
                result = selectFarm();
                if (result != null) {
                    purchaseFarm((Farm) result);
                } else {
                    System.out.println("You chose wrong number.");
                }
                break;
            case 4:
                break;
            default:
                System.out.println("You chose wrong number.");
                break;
        }
    }

    private Uparu selectUparu() {
        Uparu result = null;
        getShopUparus();
        int selection = In.readInt("Which one do you like?") - 1;
        if (selection < shopUparus.size() && selection >= 0) {
            result = shopUparus.get(selection);
            System.out.println("Your choice is " + result.getName() + ".");
        }
        return result;
    }
    private void purchaseUparu(Uparu uparu) {
        String result = "";
        if (checkMoneyPrice(uparu.getPrice())) {
            if (hasHabitat()) {
                if(compareHabitatProperty(uparu)) {
                    if (checkHabitatSize(uparu)) {
                        inventory.consumeMoney(uparu.getPrice());
                        moveToHabitat(uparu);
                        uparus.setUparu(uparu);
                        result += "Successful Purchase!!!";
                        result += "\nNow you have " + inventory.getMoney() + ".";
                    }
                } else {
                    result += "You don't have " + uparu.getProperty() + " habitat.";
                    result += "\nPurchase your " + uparu.getProperty() + " habitat first.";
                }
            } else {
                result += "You don't have any habitat.";
                result += "\nPurchase your habitat first.";
            }
        } else {
            result += "Oh, sorry. You cannot purchase this uparu.";
            result += "\nBecause you have only " + inventory.money + ".";
        }
        System.out.println(result);
    }
    private boolean checkMoneyPrice(double price) {
        boolean result = false;
        if (inventory.money >= price) {
            result = true;
        }
        return result;
    }
    private boolean hasHabitat() {
        boolean result = false;
        if (habitats.getSize() > 0) {
            result = true;
        }
        return result;
    }
    private boolean compareHabitatProperty(Uparu uparu) {
        boolean result = false;
        for (Habitat habitat : habitats.habitatList) {
            if (habitat.getProperty().equals(uparu.getProperty())) {
                result = true;
            }
        }
        return result;
    }
    private boolean checkHabitatSize(Uparu uparu) {
        boolean result = false;
        for (Habitat habitat : habitats.habitatList) {
            if (habitat.getProperty().equals(uparu.getProperty())) {
                result = habitat.checkHabitatSize();
            }
        }
        return result;
    }
    private void moveToHabitat(Uparu uparu) {
        for (Habitat habitat : habitats.habitatList) {
            if (habitat.getProperty().equals(uparu.getProperty())) {
                habitat.addUparu(uparu);
            }
        }
    }


    private Habitat selectHabitat() {
        Habitat result = null;
        getShopHabitats();
        int selection = In.readInt("Which one do you like?") - 1;
        if (selection < shopHabitats.size() && selection >= 0) {
            result = shopHabitats.get(selection);
            System.out.println("Your choice is " + result.getHabitatName() + ".");
        }
        return result;
    }
    private void purchaseHabitat(Habitat habitat) {
        String result = "";
        if (checkMoneyPrice(habitat.getPrice())) {
            if (checkHabitatProperty(habitat)) {
                inventory.consumeMoney(habitat.getPrice());
                habitats.setHabitat(habitat);
                result += "Successful Purchase!";
                result += "\nNow, you have " + inventory.getMoney() + ".";
            } else {
                result += "You already have " + habitat.getProperty() + "habitat.";
            }
        } else {
            result += "Oh, sorry. You cannot purchase this habitat.";
            result += "\nBecause you have only " + inventory.money + ".";
        }
        System.out.println(result);
    }
    private boolean checkHabitatProperty(Habitat selectHabitat) {
        boolean result = true;
        for (Habitat habitat : habitats.habitatList) {
            if (habitat.getProperty().equals(selectHabitat.getProperty())) {
                result = false;
            }
        }
        return result;
    }

    private Farm selectFarm() {
        Farm result = null;
        getShopFarms();
        int selection = In.readInt("Which one do you like?") - 1;
        if (selection < shopFarms.size() && selection >= 0) {
            result = shopFarms.get(selection);
            System.out.println("Your choice is " + result.getFruitName() + " farm.");
        }
        return result;
    }
    private void purchaseFarm(Farm farm) {
        String result = "";
        if (checkMoneyPrice(farm.getPrice())) {
            inventory.consumeMoney(farm.getPrice());
            farms.setFarm(farm);
            result += "Successful Purchase!";
            result += "\nNow, you have " + inventory.getMoney() + ".";
        } else {
            result += "Oh, sorry. You cannot purchase this farm.";
            result += "\nBecause you have only " + inventory.money + ".";
        }
        System.out.println(result);
    }


    public String toString() {
        return "-------------------------" +
        "\n         Shop" +
        "\n-------------------------" +
        "\n1. Uparu" +
        "\n2. Habitat" +
        "\n3. Farm" +
        "\n4. Go Back" +
        "\n-------------------------";
    }
}
