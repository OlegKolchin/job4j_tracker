
package ru.job4j.tracker;


public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select =  input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name =  input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] array = tracker.findAll();
                for (Item temp : array) {
                    System.out.println(temp.getId() + " " + temp.getName());
                }

            } else if (select == 2) {
                int id = input.askInt("Enter Id of the item: ");
                String name = input.askStr("Enter new name for the item: ");
                Item newItem = new Item(name);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Operation is successfully completed");
                } else {
                    System.out.println("Operation not completed");
                }
            } else if (select == 3) {
                int id = input.askInt("Enter Id of the item: ");
                if (tracker.delete(id)) {
                    System.out.println("Operation is successfully completed");
                } else {
                    System.out.println("Operation not completed");
                }
            } else if (select == 4) {
                int id = input.askInt("Enter Id of the item: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item.getId() + " " + item.getName());
                } else {
                    System.out.println("Item not found");
                }
            } else if (select == 5) {
                String name = input.askStr("Enter name of the item: ");
                Item[] items = tracker.findByName(name);
                if (items.length > 0 ) {
                    for (Item s : items) {
                        System.out.println(s.getId() + " " + s.getName());
                    }
                } else {
                    System.out.println("Item does not exist");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu");
        System.out.println("0.Add new item" + System.lineSeparator() +
                "1.Show all items" + System.lineSeparator() +
                "2.Edit item" + System.lineSeparator() +
                "3.Delete item" + System.lineSeparator() +
                "4.Find item by Id" + System.lineSeparator() +
                "5.Find items by name" + System.lineSeparator() +
                "6.exit program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

}
