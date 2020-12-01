package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    private List<Integer> list;

    public static class Builder {
        private EasyStream easyStream;

        public Builder () {
            easyStream = new EasyStream();
        }

        public EasyStream setField (List<Integer> list) {
            easyStream.list = list;
            return easyStream;
        }

        public EasyStream build() {
            return easyStream;
        }
    }

    public static EasyStream of(List<Integer> source) {
        Builder stream = new EasyStream.Builder();
        stream.setField(source);
        return stream.build();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        Builder stream = new EasyStream.Builder();
        List<Integer> rsl = new ArrayList<>();
        for (Integer a : this.list) {
            rsl.add(fun.apply(a));
        }
        stream.setField(rsl);
        return stream.build();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        Builder stream = new EasyStream.Builder();
        List<Integer> rsl = new ArrayList<>();
        for (Integer a : this.list) {
            if(fun.test(a)) {
                rsl.add(a);
            }
        }
        stream.setField(rsl);
        return stream.build();
    }

    public List<Integer> collect() {
        return this.list;
    }
}