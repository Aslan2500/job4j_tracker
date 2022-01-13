package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private boolean childDentist;

    public Dentist(String name, String surname, boolean education, int birthday, boolean childDentist) {
        super(name, surname, education, birthday);
        this.childDentist = childDentist;
    }

    public int countTeeth(int upperJaw, int lowerJaw) {
        return upperJaw + lowerJaw;
    }
}
