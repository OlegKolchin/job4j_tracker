package ru.job4j.tracker;

public class ShowItemsAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all Items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] array = tracker.findAll();
        for (Item temp : array) {
            System.out.println(temp.getId() + " " + temp.getName());
        }
        return true;
    }
}
