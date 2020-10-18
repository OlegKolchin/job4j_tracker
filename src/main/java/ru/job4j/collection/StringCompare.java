package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int index = 0; index < left.length() && index < right.length(); index++) {
            int compare = Character.compare(left.charAt(index), right.charAt(index));
            if (compare != 0) {
                return compare;
            }
        }
        if (left.length() != right.length()) {
           return left.length() > right.length() ? 1 : -1;
        }
           return 0;
    }
}