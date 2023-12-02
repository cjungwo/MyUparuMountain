package UparuMountainGUI.model;

import java.util.LinkedList;

public class Records extends Updater{
    protected LinkedList<Record> records = new LinkedList<Record>();
    protected int id = 0;

    public LinkedList<Record> getRecords() {
        return records;
    }

    protected void add(Record record) {
        records.add(record);
    }

    protected Record find(int id) {
        for (Record record : records) {
            if (record.matches(id))
                return record;
        }
        return null;
    }

    public void show() {
        System.out.println(toString());
    }

    public String toString() {
        String result = "<html><p>";
        for (Record record : records) {
            result += "<br>" + record.toString();
        }
        result += "</p></html>";
        return result;
    }
}

