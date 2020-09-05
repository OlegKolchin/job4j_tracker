
package ru.job4j.tracker;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] array = tracker.findAll();
                for (Item temp : array) {
                    System.out.println(temp.getId() + " " + temp.getName());
                }

            } else if (select == 2) {
                System.out.print("Enter Id of the item: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.print("Enter new name for the item: ");
                String name = scanner.nextLine();
                Item newItem = new Item(name);
                tracker.replace(id, newItem);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Operation is successfully completed");
                } else {
                    System.out.println("Operation not completed");
                }
            } else if (select == 3) {
                System.out.print("Enter Id of the item: ");
                int id = Integer.valueOf(scanner.nextLine());
                tracker.delete(id);
                if (tracker.findById(id) == null) {
                    System.out.println("Operation is successfully completed");
                } else {
                    System.out.println("Operation not completed");
                }
            } else if (select == 4) {
                System.out.print("Enter Id of the item: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item.getId() + " " + item.getName());
                } else {
                    System.out.println("Item not found");
                }
            } else if (select == 5) {
                System.out.print("Enter name of the item: ");
                String name = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }

}