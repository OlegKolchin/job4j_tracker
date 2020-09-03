package ru.job4j.io;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int matches = 11;
        Scanner input = new Scanner(System.in);
        int select = 0;
        for (matches = 11; matches > 0; matches -= select) {
            System.out.println("Осталось спичек - " + matches + System.lineSeparator());
            System.out.println("Игрок 1, введите число от одного до трех");
            select = Integer.valueOf(input.nextLine());
            while (select < 1 || select > 3) {
                System.out.println("Игрок 1, вы ввели неверное число, повторите ввод");
                select = Integer.valueOf(input.nextLine());
            }
            for (matches = matches - select; matches > 0; matches -= select) {
                System.out.println("Осталось спичек - " + matches + System.lineSeparator());
                System.out.println("Игрок 2, введите число от одного до трех");
                select = Integer.valueOf(input.nextLine());

                while (select < 1 || select > 3 ) {
                    System.out.println("Игрок 2, вы ввели неверное число, повторите ввод");
                    select = Integer.valueOf(input.nextLine());
                }
                break;
                }
            }
        System.out.println("Поздравляю, вы победили!");

        }

    }



