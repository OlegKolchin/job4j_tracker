package ru.job4j.stream;

import java.util.List;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CardTest {
    @Test
    public void whenAllIsOk() {
        Card card = new Card(Suit.Diamonds, Value.V_6);
        List<String> expect = List.of("Diamonds V_6", "Diamonds V_7", "Diamonds V_8");
        List<String> rsl = card.cardList(card);
        assertThat(rsl, is(expect));
    }

}