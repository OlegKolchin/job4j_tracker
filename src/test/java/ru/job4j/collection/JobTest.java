package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenCompareByName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Boris", 0),
                new Job("Alex", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareByNameReversed() {
        Comparator<Job> cmpNameReversed = new JobDescByNameReversed();
        int rsl = cmpNameReversed.compare(
                new Job("Boris", 0),
                new Job("Alex", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareByPriority() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int rsl = cmpPriority.compare(
                new Job("Boris", 0),
                new Job("Alex", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareByPriorityReversed() {
        Comparator<Job> cmpPriority = new JobDescByPriorityReversed();
        int rsl = cmpPriority.compare(
                new Job("Boris", 0),
                new Job("Alex", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareCombine() {
        Comparator<Job> cmpCombine = new JobDescByNameLn().thenComparing(new JobDescByName()).thenComparing(
                new JobDescByPriority());
        int rsl = cmpCombine.compare(
                new Job("Alex", 0),
                new Job("Alex", 1)
        );
        assertThat(rsl, lessThan(0));
    }

}