package ru.job4j.collection;

import java.util.HashMap;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        HashMap<Character, Integer> l = new HashMap<>();
        HashMap<Character, Integer> r = new HashMap<>();
        for (Character s : left.toCharArray()) {
            if (l.containsKey(s)) {
                l.put(s, l.get(s) + 1);
            }else {
                l.put(s, 1);
            }
        }
        for (Character s : right.toCharArray()) {
            if (r.containsKey(s)) {
                r.put(s, r.get(s) + 1);
            }else {
                r.put(s, 1);
            }
        }
        for (Character s : l.keySet()) {
            if (l.get(s) != r.get(s)) {
                return false;
            }
        }
        return true;

    }
}