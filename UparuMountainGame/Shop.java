package UparuMountainGame;

public class Shop {
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

    public void menu(User user) {
        Record result = null;
        int action = readAction();
        switch (action) {
            case 1:
                result = selectUparu();
                if (result != null) {
                    System.out.println("You choose " + result.getName() + ".");
                    purchaseUparu((Uparu) result, user);
                } else {
                    System.out.println("You choose wrong number");
                }
                break;
            case 2:
                result = selectHabitat();
                if (result != null) {
                    System.out.println("You choose " + result.getName() + ".");
                    purchaseHabitat((Habitat) result, user);
                } else {
                    System.out.println("You choose wrong number");
                }
                break;
            case 3:
                result = selectFarm();
                if (result != null) {
                    System.out.println("You choose " + result.getName() + ".");
                    purchaseFarm((Farm) result, user);
                } else {
                    System.out.println("You choose wrong number");
                }
                break;
            case 4:
                System.out.println("Go back to main menu.");
                break;
            default:
                System.out.println("You chose wrong number.");
                System.out.println("Go back to main menu.");
                break;
        }
    }
    private int readAction() {
        String menuString = "-------------------------" +
        "\n         Shop" +
        "\n-------------------------" +
        "\n1. Uparu" +
        "\n2. Habitat" +
        "\n3. Farm" +
        "\n4. Go Back" +
        "\n-------------------------";
        return In.readInt(menuString);
    }

    private Uparu selectUparu() {
        Uparu result = null;
        shopUparus.show();
        int selection = In.readInt("Which one do you like?");
        result = shopUparus.find(selection);
        return result;
    }

    private void purchaseUparu(Uparu uparu, User user) {
        String result = "";
        if (checkMoneyPrice(uparu.getPrice(), user.getInventory())) {
            if (hasHabitat(user.getHabitats())) {
                if(compareHabitatProperty(uparu, user.getHabitats())) {
                    if (checkHabitatSize(uparu, user.getHabitats())) {
                        user.getInventory().consumeMoney(uparu.getPrice());
                        moveToHabitat(uparu, user.getHabitats());
                        result += "Successful Purchase!!!";
                        result += "\nNow you have " + user.getInventory().getMoney() + ".";
                    } else {
                        result += uparu.getProperty() + " habitat is already full.";
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
            result += "\nBecause you have only " + user.getInventory().money + ".";
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


    private Habitat selectHabitat() {
        Habitat result = null;
        shopHabitats.show();
        int selection = In.readInt("Which one do you like?");
        result = shopHabitats.find(selection);
        return result;
    }
    private void purchaseHabitat(Habitat habitat, User user) {
        String result = "";
        if (checkMoneyPrice(habitat.getPrice(), user.getInventory())) {
            if (checkHabitatProperty(habitat, user.getHabitats())) {
                user.getInventory().consumeMoney(habitat.getPrice());
                user.getHabitats().add(habitat);
                result += "Successful Purchase!";
                result += "\nNow, you have " + user.getInventory().getMoney() + ".";
            } else {
                result += "You already have " + habitat.getProperty() + "habitat.";
            }
        } else {
            result += "Oh, sorry. You cannot purchase this habitat.";
            result += "\nBecause you have only " + user.getInventory().money + ".";
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

    private Farm selectFarm() {
        Farm result = null;
        shopFarms.show();
        int selection = In.readInt("Which one do you like?");
        result = shopFarms.find(selection);
        return result;
    }
    private void purchaseFarm(Farm farm, User user) {
        String result = "";
        if (checkMoneyPrice(farm.getPrice(), user.getInventory())) {
            user.getInventory().consumeMoney(farm.getPrice());
            user.getFarms().add(farm);
            result += "Successful Purchase!";
            result += "\nNow, you have " + user.getInventory().getMoney() + ".";
        } else {
            result += "Oh, sorry. You cannot purchase this farm.";
            result += "\nBecause you have only " + user.getInventory().money + ".";
        }
        System.out.println(result);
    }
}
