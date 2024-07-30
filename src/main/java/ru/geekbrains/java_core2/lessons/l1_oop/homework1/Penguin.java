package ru.geekbrains.java_core2.lessons.l1_oop.homework1;

public class Penguin implements RunJumping {
    String name;
    int maxDistance;
    int maxHeight;

    public Penguin(String name, int maxDistance, int maxHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
        }

    @Override
    public boolean run(int distance) {
        if(maxDistance >= distance) {
            System.out.printf("Penguin %s ran %d kilometers\n", name, distance);
            return true;
        } else {
            System.out.printf("Penguin %s dropped out of the race\n", name);
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if(maxHeight >= height) {
            System.out.printf("Penguin %s jumped %d meters high\n", name, height);
            return true;
        } else {
            System.out.printf("Penguin %s dropped out of the race\n", name);
            return false;
        }
    }
}
