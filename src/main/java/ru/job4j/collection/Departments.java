package ru.job4j.collection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (start.isEmpty()) {
                    tmp.add(el);
                    start = el;
                } else {
                    tmp.add(start + "/" + el);
                    start = start + ("/" + el);
                }

            }

        }
        return new ArrayList<>(tmp);
    }

}