package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String s : origin) {
            check.add(s);
        }
        int i = 0;
        for (String s : text) {
            if (check.contains(s)) {
                i++;
            }
        }
        return i == check.size();
    }
}