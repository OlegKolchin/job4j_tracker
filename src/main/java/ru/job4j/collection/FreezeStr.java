package ru.job4j.collection;

import java.util.HashMap;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        HashMap<Character, Integer> l = new HashMap<>();
        for (Character s : left.toCharArray()) {
            if (l.containsKey(s)) {
                l.put(s, l.get(s) + 1);
            }
            l.putIfAbsent(s, 1);
        }
        for (Character s : right.toCharArray()) {
            if (l.containsKey(s) && l.get(s) != 1) {
                l.replace(s, l.get(s) - 1);
            } else {
                l.remove(s);
            }
        }
        return l.isEmpty();
    }
}