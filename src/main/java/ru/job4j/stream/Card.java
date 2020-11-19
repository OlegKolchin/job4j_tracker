package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Card card = new Card(Suit.Diamonds, Value.V_6);
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values()))
                .map(value -> card.suit + " " + value)
                .distinct()
                .forEach(System.out::println);
    }
}
