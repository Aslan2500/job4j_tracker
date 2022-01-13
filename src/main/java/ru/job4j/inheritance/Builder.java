package ru.job4j.inheritance;

public class Builder extends Engineer {

    private int bricks;

    public Builder(String name, String surname, boolean education, int birthday) {
        super(name, surname, education, birthday);
    }

    public int floors(int floorsUp, int floorsDown) {
        return  floorsDown + floorsUp;
    }
}
