package ru.job4j.stream;

import java.util.List;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {

    @Test
    public void matrixTest() {
        Matrix matrix = new Matrix();
        List<List<Integer>> list = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        List<Integer> rsl = List.of(1, 2, 3, 4);
        List<Integer> expect = matrix.convert(list);
        assertThat(rsl, is(expect));
    }

}