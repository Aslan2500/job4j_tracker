package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionCalcTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionCalc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whQuadraticFunctionThenQuadraticResults() {
        List<Double> result = FunctionCalc.diapason(2, 5, x -> 2 * Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(9D, 17D, 33D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = FunctionCalc.diapason(2, 5, x -> 2 * Math.pow(x, x) + 1);
        List<Double> expected = Arrays.asList(9D, 55D, 513D);
        assertThat(result, is(expected));
    }
}