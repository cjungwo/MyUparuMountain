package UparuMountainGUI.model;

public class Shop extends Updater{
    private Uparus shopUparus = new Uparus();
    private Habitats shopHabitats = new Habitats();
    private Farms shopFarms = new Farms();

    public Shop() {
        setShopUparu();
        setShopHabitat();
        setShopFarms();
    }

    // setting
    private void setShopUparu() {
        shopUparus.add("Aparu", Property.Plant, 10, 10);
        shopUparus.add("Baru", Property.Fire, 20, 30);
        shopUparus.add("Caru", Property.Earth, 16, 50);
        shopUparus.add("Doru", Property.Water, 13, 100);
        shopUparus.add("Eparu", Property.Wind, 17, 200);
        shopUparus.add("Poru", Property.Ice, 15, 500);
    }

    private void setShopHabitat() {
        shopHabitats.add("PlantHabitat", Property.Plant, 1000, 3, 10);
        shopHabitats.add("FireHabitat", Property.Fire, 10000, 4, 30);
        shopHabitats.add("EarthHabitat", Property.Earth, 6000, 3, 100);
        shopHabitats.add("WaterHabitat", Property.Water, 30000, 4, 400);
        shopHabitats.add("WindHabitat", Property.Wind, 16000, 4, 800);
        shopHabitats.add("IceHabitat", Property.Ice, 8000, 3, 1200);
    }

    private void setShopFarms() {
        shopFarms.add("Strawberry",1, 10, 10);
        shopFarms.add("Apple", 2, 50, 50);
        shopFarms.add("Banana", 3, 100, 200);
        shopFarms.add("Peach", 4, 120, 500);
        shopFarms.add("Cherry", 5, 150, 2000);
        shopFarms.add("WaterMelon", 6, 300, 2500);
    }

    // getter
    public Habitats getShopHabitats() {
        return shopHabitats;
    }
    public Uparus getShopUparus() {
        return shopUparus;
    }
    public Farms getShopFarms() {
        return shopFarms;
    }

    public Uparu selectUparu(int selection) {
        Uparu result = null;
        result = shopUparus.find(selection);
        return result;
    }

    public void purchaseUparu(Uparu uparu, User user) {
        String result = "";
        if (checkMoneyPrice(uparu.getPrice(), user.getInventory())) {
            if (hasHabitat(user.getHabitats())) {
                if(compareHabitatProperty(uparu, user.getHabitats())) {
                    if (checkHabitatSize(uparu, user.getHabitats())) {
                        user.getInventory().consumeMoney(uparu.getPrice());
                        moveToHabitat(uparu, user.getHabitats());
                        result += "Successful Purchase!!!";
                        result += "<br>Now you have " + user.getInventory().getMoney() + ".";
                        updateViews();
                    } else {
                        result += uparu.getProperty() + " habitat is already full.";
                    }
                } else {
                    result += "You don't have " + uparu.getProperty() + " habitat.";
                    result += "<br>Purchase your " + uparu.getProperty() + " habitat first.";
                }
            } else {
                result += "You don't have any habitat.";
                result += "<br>Purchase your habitat first.";
            }
        } else {
            result += "Oh, sorry. You cannot purchase this uparu.";
            result += "<br>Because you have only " + user.getInventory().money + ".";
        }
        System.out.println(result);
    }
    private boolean checkMoneyPrice(int price, Inventory inventory) {
        boolean result = false;
        if (inventory.money >= price) {
            result = true;
        }
        return result;
    }
    private boolean hasHabitat(Habitats habitats) {
        boolean result = false;
        if (habitats.getSize() > 0) {
            result = true;
        }
        return result;
    }
    private boolean compareHabitatProperty(Uparu uparu, Habitats habitats) {
        boolean result;
        if (habitats.find(uparu.getProperty()) != null) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    private boolean checkHabitatSize(Uparu uparu, Habitats habitats) {
        boolean result = false;
        Habitat habitat = habitats.find(uparu.getProperty());
        if (habitat != null) {
            result = habitat.checkHabitatSize();
        }
        return result;
    }
    private void moveToHabitat(Uparu uparu, Habitats habitats) {
        Habitat habitat = habitats.find(uparu.getProperty());
        if (habitat != null) {
            habitat.addUparu(uparu.getName(), uparu.getProperty(), uparu.getMoneyPerSecond(), uparu.getPrice());
        }
    }


    public Habitat selectHabitat(int selection) {
        Habitat result = null;
        result = shopHabitats.find(selection);
        return result;
    }
    public void purchaseHabitat(Habitat habitat, User user) {
        String result = "";
        if (checkMoneyPrice(habitat.getPrice(), user.getInventory())) {
            if (checkHabitatProperty(habitat, user.getHabitats())) {
                user.getInventory().consumeMoney(habitat.getPrice());
                user.getHabitats().add(habitat);
                result += "Successful Purchase!";
                result += "<br>Now, you have " + user.getInventory().getMoney() + ".";
                updateViews();
            } else {
                result += "You already have " + habitat.getProperty() + "habitat.";
            }
        } else {
            result += "Oh, sorry. You cannot purchase this habitat.";
            result += "<br>Because you have only " + user.getInventory().money + ".";
        }
        System.out.println(result);
    }
    private boolean checkHabitatProperty(Habitat selectHabitat, Habitats habitats) {
        boolean result;
        if (habitats.find(selectHabitat.getProperty()) == null) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public Farm selectFarm(int selection) {
        Farm result = null;
        result = shopFarms.find(selection);
        return result;
    }
    public void purchaseFarm(Farm farm, User user) {
        String result = "";
        if (checkMoneyPrice(farm.getPrice(), user.getInventory())) {
            user.getInventory().consumeMoney(farm.getPrice());
            user.getFarms().add(farm);
            result += "Successful Purchase!";
            result += "<br>Now, you have " + user.getInventory().getMoney() + ".";
            updateViews();
        } else {
            result += "Oh, sorry. You cannot purchase this farm.";
            result += "<br>Because you have only " + user.getInventory().money + ".";
        }
        System.out.println(result);
    }
}
