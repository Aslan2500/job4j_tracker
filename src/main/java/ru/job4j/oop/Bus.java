package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус едет по дороге");
    }

    @Override
    public int wheightInTons() {
        return 12;
    }
}
