package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIExample {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, -6, -4);
        List<Integer> positive = list.stream().filter(
                integer -> integer > 0
        ).collect(Collectors.toList());
        System.out.println(positive);
    }
}
