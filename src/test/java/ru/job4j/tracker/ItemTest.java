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
        List<Item> items = Arrays.asList(new Item("Abc"), new Item("Dca"),
                new Item("Cab"), new Item("Bca"));
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(new Item("Abc"), new Item("Bca"),
                new Item("Cab"), new Item("Dca"));
        assertThat(items, is(expected));
    }

    @Test
    public void compareToReverse() {
        List<Item> items = Arrays.asList(new Item("Dca"), new Item("Bca"),
                new Item("Cab"), new Item("Abc"));
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(new Item("Dca"), new Item("Cab"),
                new Item("Bca"), new Item("Abc"));
        assertThat(items, is(expected));
    }
}