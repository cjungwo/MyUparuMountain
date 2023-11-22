package UparuMountainGame;
public class Farms extends Records{
    public Farms() {}

    public void menu(User user) {
        if (records.size() != 0) {
            int action = readAction();
            switch (action) {
                case 1:
                    user.harvestFruit();
                    break;
                case 2:
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
                "Please Enter your choice (1. Harvest fruits 2. Exit)");
    }

    public void add(Farm farm) {
        int previousId = farm.getId();
        farm.setId(++id);
        records.add(farm);
        farm.setId(previousId);
    }
    public void add(String name, int producingTime, int producingAmount, int price) {
        Farm farm = new Farm(++id, name, producingTime,producingAmount, price);
        records.add(farm);
    }

    public Farm find(int id) {
        return (Farm) super.find(id);
    }

    public Farm selectFarm() {
        Farm result = null;
        int selection = In.readInt("Select farm to harvest?");
        result = find(selection);
        if (result != null) {
            System.out.println("Your choice is " + result.getName() + " farm.");
            System.out.println("It takes " + result.getProducingTime() + "seconds");
        } else {
            System.out.println("You chose wrong number.");
        }
        return result;
    }

    public void show() {
        System.out.println(toString());
    }

    public String toString() {
        String result = "";
        result += "     All Farm List";
        result += "\n--------------------------";
        if (records.size() == 0) {
            result += "\nNothing in here";
        } else {
            for (Record record : records) {
                result += "\n" + record.id + ".";
                result += "\n" + ((Farm) record).toString();
            }
        }
        result += "\n--------------------------";
        return result;
    }
}
