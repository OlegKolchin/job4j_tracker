package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;
public class StartUITest {
    @Test
    public void whenAddItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }


    @Test
    public void whenEditItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        String id = Integer.toString(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, replacedName, "1",}
        );
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        String id = Integer.toString(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
    @Test
    public void whenShowItemsAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowItemsAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu" + System.lineSeparator() +
                        "0. === Show all Items ====" + System.lineSeparator() +
                        "1. === Exit program ====" + System.lineSeparator() +
                        item.getId() + " " + item.getName() + System.lineSeparator() +
                        "Menu" + System.lineSeparator() +
                        "0. === Show all Items ====" + System.lineSeparator() +
                        "1. === Exit program ====" + System.lineSeparator()));;
    }

    @Test
    public void whenFindItemByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        String id = Integer.toString(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1"}
        );
        UserAction[] actions = {
                new FindItemByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu" + System.lineSeparator() +
                        "0. === Find Item by Id ====" + System.lineSeparator() +
                        "1. === Exit program ====" + System.lineSeparator() +
                        item.getId() + " " + item.getName() + System.lineSeparator() +
                        "Menu" + System.lineSeparator() +
                        "0. === Find Item by Id ====" + System.lineSeparator() +
                        "1. === Exit program ====" + System.lineSeparator()));;
    }

    @Test
    public void whenFindItemsByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        Input in = new StubInput(
                new String[] {"0", item.getName(), "1"}
        );
        UserAction[] actions = {
                new FindItemsByName(out),
                new ExitAction()

        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu" + System.lineSeparator() +
                        "0. === Find Items by name ====" + System.lineSeparator() +
                        "1. === Exit program ====" + System.lineSeparator() +
                        item.getId() + " " + item.getName() + System.lineSeparator() +
                        "Menu" + System.lineSeparator() +
                        "0. === Find Items by name ====" + System.lineSeparator() +
                        "1. === Exit program ====" + System.lineSeparator()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu" + System.lineSeparator() +
                        "0. === Exit program ====" + System.lineSeparator()
        ));
    }



}