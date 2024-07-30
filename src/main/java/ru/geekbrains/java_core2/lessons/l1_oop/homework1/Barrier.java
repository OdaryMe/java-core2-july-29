package ru.geekbrains.java_core2.lessons.l1_oop.homework1;

public class Barrier implements Obstacle {
    private int size;

    public Barrier(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
