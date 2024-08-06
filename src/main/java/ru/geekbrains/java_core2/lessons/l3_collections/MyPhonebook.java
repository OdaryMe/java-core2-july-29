package ru.geekbrains.java_core2.lessons.l3_collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyPhonebook {
    private HashMap<String, String> phonebook;

    public MyPhonebook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String phonenumber, String name) {
        phonebook.put(phonenumber, name);
    }

    public List<String> get(String name) {
        List<String> list = new ArrayList<>();
        for (HashMap.Entry<String, String> entry : phonebook.entrySet()) {
            if(entry.getValue().equals(name)) {
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
