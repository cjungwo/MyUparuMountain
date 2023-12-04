package UparuMountainGUI.model;

public class Record extends Updater{
    protected int id = 0;
    protected String name;

    public Record(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected boolean matches(int id) {
        return this.id == id;
    }
    protected void show() {
        System.out.println(toString());
    }

    public String toString() {
        return "";
    }
}
