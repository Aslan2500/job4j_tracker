package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        int res = 0;
        for (int n : number) {
            total = add(
                    () -> {
                        return n;
                    }
            );
            res += total;
        }
        System.out.println(res);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}