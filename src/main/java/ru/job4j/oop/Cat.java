package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.println(this.name);
        System.out.println(this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        String say = peppy.sound();
        System.out.println("Peppy says " + say);
        Cat gav = new Cat();
        System.out.println("There are gav's food.");
        gav.eat("kotleta");
        gav.giveNick("Gav");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Black");
        black.show();
    }

    public String sound() {
        String voice = "may-may";
        return voice;
    }
}
