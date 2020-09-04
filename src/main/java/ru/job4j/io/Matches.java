package ru.job4j.io;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int matches = 11;
        Scanner input = new Scanner(System.in);
        int select = 0;
        String name = "Игрок 1";
        boolean player = true;
        while (matches > 0) {
            if (player) {
                name = "Игрок 1";
            } else {
                name = "Игрок 2";
            }
            System.out.println("Осталось спичек - " + matches);
            System.out.print(name + ", введите число от 1 до 3: ");
            select = Integer.valueOf(input.nextLine());
            System.out.print(System.lineSeparator());
            while (select < 1 || select > 3) {
                System.out.print(name + ", вы ввели неверное число, повторите ввод: ");
                select = Integer.valueOf(input.nextLine());
            }
            matches -= select;
            player = !player;
        }
        System.out.println(name + ", поздравляю, вы победили!");
    }
}



