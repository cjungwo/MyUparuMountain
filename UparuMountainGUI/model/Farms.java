package UparuMountainGUI.model;

public class Farms extends Records{
    public Farms() {}

    public void add(String name, int producingTime, int producingAmount, int price) {
        Farm farm = new Farm(++id, name, producingTime,producingAmount, price);
        records.add(farm);
        updateViews();
    }

    public Farm find(int id) {
        return (Farm) super.find(id);
    }

    public void show() {
        System.out.println(toString());
    }

    public String toString() {
        String result = "<html><p style='text-align:center;'>";
        result += "     All Farm List";
        result += "<br>--------------------------";
        if (records.size() == 0) {
            result += "<br>Nothing in here";
        } else {
            for (Record record : records) {
                result += "<br>" + record.id + ". " + record.name + "Farm" ;
                result += "<br>" + ((Farm) record).toString();
            }
        }
        result += "<br>--------------------------</p></html>";
        return result;
    }
}
