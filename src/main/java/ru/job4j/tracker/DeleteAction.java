package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete an Item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Enter Id of the item: ");
        if (tracker.delete(id)) {
            out.println("Operation is successfully completed");
        } else {
            out.println("Operation not completed");
        }
        return true;
    }
}
