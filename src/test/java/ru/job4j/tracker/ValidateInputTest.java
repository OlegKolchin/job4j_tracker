
package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

public class ValidateInputTest {

    @Test
    public void whenInValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(out.toString(), is(
                "Please enter validate data again." + System.lineSeparator()
        ));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1", "0", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new ExitAction()
        );

        new StartUI(out).init(in, tracker, actions);

        assertThat(out.toString(), Is.is(
                String.format(
                        "Menu%n"
                                + "0. === Exit program ====%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu%n"
                                + "0. === Exit program ====%n"
                )
        ));
    }
}