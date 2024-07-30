package ru.geekbrains.java_core2.lessons.l1_oop.homework1;

public class Barrier implements Obstacle {
    private int height;

    public Barrier(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
