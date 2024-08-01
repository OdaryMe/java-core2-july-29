package ru.geekbrains.java_core2.lessons.l1_oop.homework1;

public class Goblin implements RunJumping {
    String name;
    int maxDistance;
    int maxJump;

    public Goblin(String name, int maxDistance, int maxHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxJump = maxJump;
    }

    @Override
    public boolean run(int distance) {
        if(maxDistance >= distance) {
            System.out.printf("Goblin %s ran %d kilometers\n", name, distance);
            return true;
        } else {
            System.out.printf("Goblin %s dropped out of the race\n", name);
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if(maxJump >= height) {
        System.out.printf("Goblin %s jumped %d meters high\n", name, height);
            return true;
    } else {
        System.out.printf("Goblin %s dropped out of the race\n", name);
            return false;
    }
}
}
