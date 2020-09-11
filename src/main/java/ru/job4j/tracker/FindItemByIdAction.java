package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id of the item: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item.getId() + " " + item.getName());
        } else {
            System.out.println("Item not found");
        }
        return true;
    }
}
