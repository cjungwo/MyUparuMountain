package UparuMountainGame;

public class User {
    private int id;
    private String name;

    private Habitats habitats = new Habitats();
    private Farms farms = new Farms();
    private Inventory inventory = new Inventory();

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter
    public Habitats getHabitats() {
        return habitats;
    }

    public Farms getFarms() {
        return farms;
    }

    public Inventory getInventory() {
        return inventory;
    }


    public void showHabitats() {
        habitats.show();
        habitats.menu(this);
    }

    public void showFarms() {
        farms.show();
        farms.menu(this);
    }

    public void feedInHabitat(Habitat habitat) {
        System.out.println("Do you want to feed your uparu? (Y/N)");
        char choice = In.nextUpperChar();
        if (choice == 'Y') {
            Uparu selectUparu = habitat.getUparusInHabitat().selectUparu();
            if (selectUparu != null) {
                selectUparu.eatFruit(inventory);
            }
        }
    }

    public void harvestMoney() {
        Habitat selectHabitat = habitats.selectHabitat();
        if (selectHabitat != null) {
            selectHabitat.harvestMoney(inventory);
        }
    }

    public void harvestFruit() {
        Farm selectFarm = farms.selectFarm();
        if (selectFarm != null) {
            selectFarm.harvestFruit(inventory);
        }
    }

    @Override
    public String toString() {
        return "User ID : " + id + "\nUser Name : " + name + "\n" + habitats.toString() + "\n" + farms.toString();
    }
}