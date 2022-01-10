package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Fox fox = new Fox();
        Wolf wolf = new Wolf();
        Hare hare = new Hare();
        Ball ball = new Ball();
        wolf.tryEat(ball);
        hare.tryEat(ball);
        fox.tryEat(ball);
    }
}
