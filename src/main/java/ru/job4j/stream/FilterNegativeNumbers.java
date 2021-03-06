package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 5, 25, 421, -333, 322, -7, 4, -1);
        List<Integer> positive = numbers.stream().filter(task -> task > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
