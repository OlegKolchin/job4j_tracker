package ru.job4j.tracker;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;


public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }
    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void sortByIdReversed() {
        Tracker tracker = new Tracker();
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("third");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> expect = List.of(third, second, first);
        List<Item> rsl = tracker.findAll();
        Collections.sort(rsl, Collections.reverseOrder());
        assertThat(rsl, is(expect));

    }
    @Test
    public void sortByName() {
        Tracker tracker = new Tracker();
        Item first = new Item("C");
        Item second = new Item("B");
        Item third = new Item("A");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> expect = List.of(third, second, first);
        List<Item> rsl = tracker.findAll();
        Collections.sort(rsl, new SortByItemsName());
        assertThat(rsl, is(expect));

    }

    @Test
    public void sortByNameReversed() {
        Tracker tracker = new Tracker();
        Item first = new Item("A");
        Item second = new Item("B");
        Item third = new Item("C");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> expect = List.of(third, second, first);
        List<Item> rsl = tracker.findAll();
        Collections.sort(rsl, new SortByItemsNameReversed());
        assertThat(rsl, is(expect));
    }

}