package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void compareTo() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("Abc");
        Item item2 = new Item("Dca");
        Item item3 = new Item("Cab");
        Item item4 = new Item("Bca");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(new Item("Abc"), new Item("Bca"),
                new Item("Cab"), new Item("Dca"));
        assertThat(items, is(expected));
    }

    @Test
    public void compareToReverse() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("Abc");
        Item item2 = new Item("Dca");
        Item item3 = new Item("Cab");
        Item item4 = new Item("Bca");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(new Item("Dca"), new Item("Cab"),
                new Item("Bca"), new Item("Abc"));
        assertThat(items, is(expected));
    }
}