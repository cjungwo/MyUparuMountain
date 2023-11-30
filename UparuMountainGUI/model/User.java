package UparuMountainGUI.model;

import UparuMountainGUI.In;

public class User extends Updater{
    private int id;
    private String name;

    private Habitats habitats = new Habitats();
    private Farms farms = new Farms();
    private Inventory inventory = new Inventory();

    private User() {}

    public static User getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
		private static final User INSTANCE = new User();
	}
    
    public void set(int id, String name)
    {
        this.id = id;
        this.name = name;
        updateViews();
    }

    // Getter
    public String getName() {
        return name;
    }
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
        return "<html><p>User ID : " + id + "<br>User Name : " + name + "<br>" + inventory.toString() + "<br>" + habitats.toString() + "<br>" + farms.toString() + "</p></html>" ;
    }
}