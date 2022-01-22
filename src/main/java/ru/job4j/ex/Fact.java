package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        new Fact().calc(-1);
    }

    public int calc(int n) {
        int rsl = 1;
        if (n < 0) {
            throw new IllegalArgumentException("Number has to be higher than zero or equal to zero");
        }
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
