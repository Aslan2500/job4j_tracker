package ru.job4j.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combineSurname = surname -> key.equals(surname.getSurname());
        Predicate<Person> combineName = name -> key.equals(name.getName());
        Predicate<Person> combinePhone = phone -> key.equals(phone.getPhone());
        Predicate<Person> combineAddress = address -> key.equals(address.getAddress());
        Predicate<Person> combine = pred -> persons.stream().allMatch(combineSurname.or(combineName.or(combinePhone.or(combineAddress))));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
