package ru.geekbrains.java_core2.lessons.l3_collections;

import java.util.*;

public class Hw_Collections {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        task1();
        System.out.println("\nЗадание 2. Вариант 1");
        task2Phonebook1("Jonn Smith");
        System.out.println("\nЗадание 2. Вариант 2");
        task2Phonebook2("Jonn Smith");
    }

    private static void task2Phonebook2(String name) {
        PhoneContacts contacts = new PhoneContacts();

        contacts.add("Jonn Smith", "16850261049");
        contacts.add("Jonn Smith", "17264930240");
        contacts.add("Jonn Smith", "13950115421");
        contacts.add("Elly Smith", "19187452136");
        contacts.add("Sam Jonn", "13589451307");
        contacts.add("Freddy Cruger", "19253458792");
        contacts.add("Tom Anderson", "19849654218");
        contacts.add("Tom Anderson", "19849654106");

        System.out.println(contacts.get(name));
    }

    private static void task2Phonebook1(String name) {

        MyPhonebook phonebook = new MyPhonebook();

        phonebook.add("19166547895","Jonn Smith");
        phonebook.add("19430125670","Jonn Smith");
        phonebook.add("16850261049","Jonn Smith");
        phonebook.add("19187452136", "Elly Smith");
        phonebook.add("13589451307", "Sam Jonn");
        phonebook.add("19253458792", "Freddy Cruger");
        phonebook.add("19849654218","Tom Anderson");
        phonebook.add("19849654106","Tom Anderson");
        phonebook.add("19043025689", "Peggy Adams");
        phonebook.add("19302365010", "Eleonor McGregor");
        phonebook.add("11230562174", "Willy Williams");
        phonebook.add("12580361245", "Sandy Rouse");
        phonebook.add("14580012356", "Jimmy Black");

        System.out.println(phonebook.get(name));
    }

    private static void task1() {
        String[] someWords = {
                "apple",
                "wall",
                "friendship",
                "basket",
                "opportunity",
                "wall",
                "enterprises",
                "apple",
                "basket",
                "details",
                "basket",
                "wall",
                "basket",
                "basket",
                "beach"
        };

        Set<String> setUniq = new HashSet<>();
        setUniq.addAll(Arrays.asList(someWords));
        System.out.println("Unique array elements: " + setUniq);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < someWords.length; i++) {
            var value = map.get(someWords[i]);
            int count = value == null ? 0 : value;
            map.put(someWords[i], count + 1);
        }
        System.out.println("Frequency of repetitions of words: " + map);
    }
}
