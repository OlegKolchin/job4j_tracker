package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit an Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id of the item: ");
        String name = input.askStr("Enter new name for the item: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Operation is successfully completed");
        } else {
            System.out.println("Operation not completed");
        }
        return true;
    }
}
