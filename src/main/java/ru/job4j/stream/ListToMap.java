package ru.job4j.stream;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

    public static Map<String, Student> convert(List<Student> list) {
        Map<String, Student> rsl = list.stream()
                .collect(Collectors.toMap(Student::getSurname, student -> student,
                        (surname1, surname2) -> surname1));
        return rsl;
    }
}
