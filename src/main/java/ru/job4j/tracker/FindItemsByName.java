package ru.job4j.tracker;

import java.util.List;

public class FindItemsByName implements UserAction {
    private final Output out;

    public FindItemsByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find Items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name of the item: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item s : items) {
                out.println(s.getId() + " " + s.getName());
            }
        } else {
            out.println("Item does not exist");
        }
        return true;
    }
}
