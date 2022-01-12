package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void when00to20then2() {
        double expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when003to204then2() {
        double expected = 2;
        Point a = new Point(0, 0, 3);
        Point b = new Point(2, 0, 4);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}
