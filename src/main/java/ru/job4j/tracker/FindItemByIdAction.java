package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    private final Output out;

    public FindItemByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find Item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id of the item: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item.getId() + " " + item.getName());
        } else {
            out.println("Item not found");
        }
        return true;
    }
}
