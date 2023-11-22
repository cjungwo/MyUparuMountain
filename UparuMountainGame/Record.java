package UparuMountainGame;

public class Record {
    protected int id;
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
