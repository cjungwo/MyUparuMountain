package UparuMountainGUI.model;

import UparuMountainGUI.In;

public class Habitats extends Records{
    
    public Habitats() {}

    public int getSize() {
        return records.size();
    }

    public void menu(User user) {
        if (records.size() != 0) {
            int action = readAction();
            switch (action) {
                case 1:
                    user.harvestMoney();
                    break;
                case 2:
                    showSelectedHabitat(user);
                    break;
                case 3:
                    System.out.println("Go back to main menu.");
                    break;
                default:
                    System.out.println("You chose wrong number.");
                    break;
            }
        }
    }
    private int readAction() {
        return In.readInt(
                "Please Enter your choice (1. Harvest Money 2. Show uparu in habitat 3. Exit)");
    }

    public void add(Habitat habitat) {
        int previousId = habitat.getId();
        habitat.setId(++id);
        records.add(habitat);
        habitat.setId(previousId);
        updateViews();
    }

    public void add(String name, Property property, int moneyCapacity, int uparuCapacity, int price) {
        Habitat habitat = new Habitat(++id, name, property, moneyCapacity, uparuCapacity, price);
        records.add(habitat);
        updateViews();
    }

    public Habitat find(int id) {
        return (Habitat) super.find(id);
    }

    public Habitat find(Property property) {
        for (Record habitat : records) {
            if (((Habitat)habitat).getProperty().equals(property)) {
                return (Habitat)habitat;
            }
        }
        return null;
    }

    public Habitat selectHabitat() {
        Habitat result = null;
        int selection = In.readInt("Select number of habitat");
        result = find(selection);
        if (result != null) {
            System.out.println("Your choice is " + result.name + ".");
        } else {
            System.out.println("You select wrong number of habitat.");
        }
        return result;
    }

    private void showSelectedHabitat(User user) {
        Habitat selectHabitat = selectHabitat();
        if (selectHabitat != null) {
            System.out.println(selectHabitat.showUparusInHabitat());
            if (!selectHabitat.checkEmpty()) {
                user.feedInHabitat(selectHabitat);
                updateViews();
            }
        }
    }

    public void show() {
        System.out.println(toString());
    }

    public String toString() {
        String result = "<html><p style='text-align:center;'>";
        result += "     All Habitat List";
        result += "<br>--------------------------";
        if (records.size() == 0) {
            result += "<br>Nothing in here";
        } else {
            for (Record record : records) {
                result += "<br>" + record.id + ". " + record.name;
                result += "<br>" + ((Habitat) record).toString();
            }
        }
        result += "<br>--------------------------</p></html>";
        return result;
    }
}
