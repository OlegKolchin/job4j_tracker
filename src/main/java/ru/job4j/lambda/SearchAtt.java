package ru.job4j.lambda;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (predicate.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Attachment> list = List.of (
                new Attachment("Bob", 100),
                new Attachment("Bob", 200),
                new Attachment("five", 99),
                new Attachment("five", 100)
        );
        System.out.println(filter(list, x -> x.getSize() < 100 && x.getName().equals("five")));
    }

    Comparator<String> cmpText = (left, right) ->  {
        System.out.println("compare - " + left.length() + " : " + right.length());
        return right.length() - left.length();
    };
}