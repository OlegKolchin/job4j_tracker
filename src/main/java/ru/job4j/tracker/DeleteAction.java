package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete an Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id of the item: ");
        if (tracker.delete(id)) {
            System.out.println("Operation is successfully completed");
        } else {
            System.out.println("Operation not completed");
        }
        return true;
    }
}
