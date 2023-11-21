package UparuMountainGame;

import java.util.LinkedList;

public class Habitats {
    private static Habitats habitats;
    LinkedList<Habitat> habitatList;

    public Habitats() {
        habitatList = new LinkedList<Habitat>();
    }

    public static Habitats getHabitats() {
        if (habitats == null) {
            synchronized (Habitats.class) {
                habitats = new Habitats();
            }
        }
        return habitats;
    }

    public int getSize() {
        return habitatList.size();
    }

    public void setHabitat(Habitat habitat) {
        habitatList.add(habitat);
    }

    public void menu() {
        showHabitats();
        if (habitatList.size() != 0) {
            int action = readAction();
            switch (action) {
                case 1:
                    harvest();
                    break;
                case 2:
                    show();
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

    public void showHabitats() {
        System.out.println(In.showList("Habitat", habitatList));
    }

    private void harvest() {
        Habitat selectHabitat = selectHabitat();
        if (selectHabitat != null) {
            selectHabitat.harvestMoney(Inventory.getInventory());
        } else {
            System.out.println("You select wrong number of habitat.");
        }
    }
    private Habitat selectHabitat() {
        Habitat result = null;
        int selection = In.readInt("Select number of habitat") - 1;
        if (selection < habitatList.size() && selection >= 0) {
            result = habitatList.get(selection);
            System.out.println("Your choice is " + result.getHabitatName() + ".");
        }
        return result;
    }

    private void show() {
        Habitat selectHabitat = selectHabitat();
        if (selectHabitat != null) {
            System.out.println(selectHabitat.showUparusInHabitat());
            System.out.println("Do you want to feed your uparu? (Y/N)");
            char choice = In.nextUpperChar();
            if (choice == 'Y') {
                selectHabitat.feedUparu(Inventory.getInventory());
            }
        } else {
            System.out.println("You select wrong number of habitat.");
        }
    }
}
