package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String language;

    public Programmer(String name, String surname, boolean education, int birthday) {
        super(name, surname, education, birthday);
    }

    public String language(String programmerLanguage) {
        return programmerLanguage;
    }
}
