package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public List<String> cardList(Card card) {
       return Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values()))
                .map(value -> card.suit + " " + value)
                .distinct()
                .collect(Collectors.toList());

    }

}
