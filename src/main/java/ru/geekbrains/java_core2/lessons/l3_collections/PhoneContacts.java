package ru.geekbrains.java_core2.lessons.l3_collections;

import java.util.*;


public class PhoneContacts {
    private HashMap<String, List<String>> contacts;

    public PhoneContacts() {
        this.contacts = new HashMap<>();
    }

    public void add(String name, String number) {
        List<String> list = contacts.get(name);
        if (contacts.get(name) == null) {
            list = new ArrayList<>();
            list.add(number);
            contacts.put(name, list);
        } else {
            list.add(number);
        }
    }

    public List<String> get(String name) {
        List<String> list = contacts.get(name);
        return list;
    }
}
