package UparuMountainGUI.model;

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

    @Override
    public String toString() {
        return "<html><p>User ID : " + id + "<br>User Name : " + name + "<br>" + inventory.toString() + "<br>" + allUparus() + "<br>" + farms.toString() + "</p></html>" ;
    }
    private String allUparus() {
        String result = "<p style='text-align:center'>";
        String uparus = "";
        result += "     All Uparu List";
        result += "<br>--------------------------";
        int i = 1;
        if (habitats.getSize() == 0) {
            result += "<br>Nothing in here";
        } else {
            for (Record record : habitats.getRecords()) {
                Habitat habitat = (Habitat) record;
                for (Record record2 : habitat.getUparusInHabitat().getRecords()) {
                    Uparu uparu = (Uparu) record2;
                    uparus += "<br>" + i++ + ". "+ uparu.getName();
                }
            }
            if (uparus.equals("")) {
                result += "<br>Nothing in here";
            } else {
                result += uparus;
            }
        }
        result += "<br>--------------------------</p>";
        return result;
    }
}