package UparuMountainGUI.model;

public class Uparus extends Records{
    public Uparus() {}
    
    public void add(String name, Property property, int moneyPerSecond, int price) {
        Uparu uparu = new Uparu(++id, name, property, moneyPerSecond, price);
        records.add(uparu);
        updateViews();
    }

    public Uparu find(int id) {
        return (Uparu) super.find(id);
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
