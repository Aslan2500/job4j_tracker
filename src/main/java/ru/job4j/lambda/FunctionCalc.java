package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionCalc {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> res = new ArrayList<>();
        for (int i = start; i < end; i++) {
            double index = (double) i;
            res.add(func.apply(index));
        }
        return res;
    }
}
