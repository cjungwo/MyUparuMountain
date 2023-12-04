package UparuMountainGUI.model;

public class Habitats extends Records{ 
    public Habitats() {}

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
            if (((Habitat) habitat).getProperty().equals(property)) {
                return (Habitat) habitat;
            }
        }
        return null;
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
