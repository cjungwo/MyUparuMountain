package UparuMountainGUI.model;

import UparuMountainGUI.In;

public class Uparus extends Records{
    public Uparus() {}

    public void add(Uparu uparu) {
        int previousId = uparu.getId();
        uparu.setId(++id);
        records.add(uparu);
        uparu.setId(previousId);
    }
    public void add(String name, Property property, int moneyPerSecond, int price) {
        Uparu uparu = new Uparu(++id, name, property, moneyPerSecond, price);
        records.add(uparu);
    }

    public Uparu find(int id) {
        return (Uparu) super.find(id);
    }

    public Uparu selectUparu() {
        Uparu result = null;
        int selection = In.readInt("Select number of uparu for feeding");
        result = find(selection);
        if (result != null) {
            System.out.println("Your choice is " + result.getName() + ".");
        } else {
            System.out.println("You chose wrong number.");
        }
        return result;
    }

    public void show() {
        System.out.println(toString());
    }

    public String toString() {
        String result = "<html><p style='text-align:center;'>";
        result += "     All Uparu List";
        result += "<br>--------------------------";
        if (records.size() == 0) {
            result += "<br>Nothing in here";
        } else {
            for (Record record : records) {
                result += "<br>" + record.id + ". " + record.name;
                result += "<br>" + ((Uparu) record).toString();
            }
        }
        result += "<br>--------------------------</p></html>";
        return result;
    }
}
