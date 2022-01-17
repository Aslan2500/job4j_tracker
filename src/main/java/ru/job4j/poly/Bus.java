package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Go go go");
    }

    @Override
    public void passengers(int numOfPassengers) {
        System.out.println("Количество пассажиров: " + numOfPassengers);
    }

    @Override
    public int refuel(int amountOfFuel) {
        return amountOfFuel;
    }
}
