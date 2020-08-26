package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book java = new Book("Java", 1000);
        Book space = new Book("Space", 345);
        Book pin = new Book("Pinoccio", 234);
        Book code = new Book("Clean Code", 200);
        Book[] array = new Book[]{java, space, pin, code};
        for (int index = 0; index < array.length; index++) {
            Book bk = array[index];
            System.out.println(bk.getName() + "," + bk.getPages());
        }
        Book temp = array[0];
        array[0] = array[3];
        array[3] = temp;
        for (int index = 0; index < array.length; index++) {
            Book bk = array[index];
            System.out.println(bk.getName() + "," + bk.getPages());
        }
        for (int index = 0; index < array.length; index++) {
            Book bk = array[index];
            if (bk.getName().equals("Clean Code")) {
                System.out.println(bk.getName() + "," + bk.getPages());
            }
        }

    }
}
