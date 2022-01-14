package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private int numberOfOperations;

    public Surgeon(String name, String surname, boolean education, int birthday) {
        super(name, surname, education, birthday, 5);
    }

    public boolean isHeartSurgeon(boolean typeOfSurgeon) {
        return typeOfSurgeon;
    }
}
