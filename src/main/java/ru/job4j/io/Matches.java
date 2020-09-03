package ru.job4j.io;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int matches = 11;
        Scanner input = new Scanner(System.in);
        int select = 0;
        for (matches = 11; matches > 0; matches -= select) {
            System.out.println("Осталось спичек - " + matches);
            System.out.println("Введите число от одного до трех");
            select = Integer.valueOf(input.nextLine());
            if (select < 1 || select > 3) {
                System.out.println("Вы ввели неверное число");
                select = 0;
            }

        }
        if (matches == 0) {
            System.out.println("Cпички закончились. Вы победили");
        }

    }
}
