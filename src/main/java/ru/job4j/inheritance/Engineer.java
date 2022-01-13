package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String nameOfCompany;

    public Engineer(String name, String surname, boolean education, int birthday) {
        super(name, surname, education, birthday);
    }

    public String softOrNot(String typeOfEngineer) {
        return typeOfEngineer;
    }
}
