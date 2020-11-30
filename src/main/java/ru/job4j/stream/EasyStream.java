package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    private List<Integer> list;

    public static EasyStream of(List<Integer> source) {
        EasyStream stream = new EasyStream();
        stream.setList(source);
        return stream;
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer a : this.list) {
            rsl.add(fun.apply(a));
        }
        setList(rsl);
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer a : this.list) {
            if(fun.test(a)) {
                rsl.add(a);
            }
        }
        setList(rsl);
        return this;
    }

    public List<Integer> collect() {
        return getList();

    }
}