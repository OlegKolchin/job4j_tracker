package ru.job4j.tracker;

public class ShowItemsAction implements UserAction {
    private final Output out;

    public ShowItemsAction (Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "=== Show all Items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] array = tracker.findAll();
        for (Item temp : array) {
            out.println(temp.getId() + " " + temp.getName());
        }
        return true;
    }
}
