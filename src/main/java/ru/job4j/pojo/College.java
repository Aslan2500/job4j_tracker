package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student mikHail = new Student();
        mikHail.setFio("ChMS");
        mikHail.setGroup(881);
        mikHail.setDate(2018);
        System.out.println(mikHail.getFio() + " " + mikHail.getGroup() + " " + mikHail.getDate());
    }
}
