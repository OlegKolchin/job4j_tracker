package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class FuncDiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {

        List<Double> result = FuncDiapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void squareFunction() {
        List<Double> result = FuncDiapason.diapason(5, 8, x -> 2 * Math.pow(x, 2) + 2 * x + 3);
        List<Double> expected = Arrays.asList(63D, 87D, 115D);
        assertThat(result, is(expected));
    }

    @Test
    public void thirdFunction() {
        List<Double> result = FuncDiapason.diapason(5, 8, x -> 2 * Math.pow(x, x) + 2 * x + 3);
        List<Double> expected = Arrays.asList(6263D, 93327D, 1647103D);
        assertThat(result, is(expected));
    }

}