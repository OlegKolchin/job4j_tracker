package ru.job4j.tracker;

public class FindItemsByName implements UserAction {
    @Override
    public String name() {
        return "=== Find Items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name of the item: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item s : items) {
                System.out.println(s.getId() + " " + s.getName());
            }
        } else {
            System.out.println("Item does not exist");
        }
        return true;
    }
}
