package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> ourMap = new HashMap<>();
        ourMap.put("aslanmagamaev@mail.ru", "Aslan");
        for (String key : ourMap.keySet()) {
            String value = ourMap.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
