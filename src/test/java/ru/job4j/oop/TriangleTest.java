package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TriangleTest {

    @Test
    public void area() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(8, 0.001));
    }

    @Test
    public void areaNew() {
        Point a = new Point(0, 0);
        Point b = new Point(6, 0);
        Point c = new Point(0, 6);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(18, 0.001));
    }

    @Test
    public void areaNewNew() {
        Point a = new Point(0, 0);
        Point b = new Point(10, 0);
        Point c = new Point(0, 10);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(50, 0.001));
    }

    @Test
    public void areaMinusOne() {
        Point a = new Point(1000, 0);
        Point b = new Point(1, 0);
        Point c = new Point(10, 0);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(-1, 0.001));
    }
}
