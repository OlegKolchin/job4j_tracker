package ru.job4j.collection;

import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String[] first = origin.split(" ");
        String[] second = line.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String s : first) {
            check.add(s.replaceAll("\\p{P}", ""));
        }
        for (String s : second) {
            if (!check.contains(s)) {
                return false;
            }
        }
        return true;
    }
}