package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        int res = 0;
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            total = add(
                    () -> num
            );
            res += total;
        }
        System.out.println(res);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}