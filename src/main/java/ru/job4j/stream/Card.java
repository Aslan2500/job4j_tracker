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
        Suit[] suits = {Suit.Clubs, Suit.Diamonds, Suit.Hearts, Suit.Spades};
        Value[] values = {Value.V_6, Value.V_7, Value.V_8};
        Stream.of(suits)
                .flatMap(suit -> Stream.of(values)
                        .map(value -> suit + " " + value))
                .forEach(System.out::println);
    }
}
