package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String firstText : origin) {
            check.add(firstText);
        }
        for (String secondTextCheck : text) {
            if (!check.contains(secondTextCheck)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
