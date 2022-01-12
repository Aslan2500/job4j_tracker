package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int left = 1;
        int right = 2;
        int result = Max.max(left, right);
        int expected = 2;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax10To1Then10() {
        int left = 10;
        int right = 1;
        int result = Max.max(left, right);
        int expected = 10;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax2To5Then5() {
        int left = 2;
        int right = 5;
        int result = Max.max(left, right);
        int expected = 5;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax5To5Then5() {
        int left = 5;
        int right = 5;
        int result = Max.max(left, right);
        int expected = 5;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax1To5To12Then12() {
        int first = 1;
        int second = 5;
        int third = 12;
        int result = Max.max(first, second, third);
        int expected = 12;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax25To2To13To246Then246() {
        int first = 25;
        int second = 2;
        int third = 13;
        int fourth = 246;
        int result = Max.max(first, second, third, fourth);
        int expected = 246;
        Assert.assertEquals(result, expected);
    }
}
