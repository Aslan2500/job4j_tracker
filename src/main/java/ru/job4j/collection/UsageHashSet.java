package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>();
        autos.add("Lada");
        autos.add("Toyota");
        autos.add("BMW");
        autos.add("Volvo");
        autos.add("BMW");
        autos.add("Lada");
        autos.add("Toyota");
        for (String elements : autos) {
            System.out.println(elements);
        }
    }
}
