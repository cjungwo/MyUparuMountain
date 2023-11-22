package UparuMountainGame;

import java.util.LinkedList;

public class Records {
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
        String result = "";
        for (Record record : records) {
            result += "\n" + record.toString();
        }   
        return result;
    }
}

