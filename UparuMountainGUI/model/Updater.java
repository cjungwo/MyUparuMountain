package UparuMountainGUI.model;

import java.util.LinkedList;

public class Updater {
    protected LinkedList<Observer> views = new LinkedList<Observer>();

    public Updater() {}

    public void attach(Observer o) {
        views.add(o);
    }

    public void detach(Observer o) {
        views.remove(o);
    }

    public void updateViews() {
        for (Observer view : views) {
            view.update();
        }
    }
}
