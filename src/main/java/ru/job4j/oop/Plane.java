package ru.job4j.oop;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println("Самолет летает");
    }

    @Override
    public int wheightInTons() {
        return 100;
    }
}
