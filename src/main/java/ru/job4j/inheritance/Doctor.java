package ru.job4j.inheritance;

public class Doctor extends Profession {

    private int yearsOfEducation;

    public Doctor(String name, String surname, boolean education, int birthday, int yearsOfEducation) {
        super(name, surname, education, birthday);
        this.yearsOfEducation = yearsOfEducation;
    }

    public Diagnosis heal(Pacient pacient) {
        boolean isHeGonnaDie = pacient.oldPerson;
        return new Diagnosis(isHeGonnaDie);
    }
}
