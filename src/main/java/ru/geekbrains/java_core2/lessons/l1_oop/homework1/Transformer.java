package ru.geekbrains.java_core2.lessons.l1_oop.homework1;

public class Transformer implements RunJumping{
    String model;
    int maxDistance;
    int maxHeight;

    public Transformer(String model, int maxDistance, int maxHeight) {
        this.model = model;
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean run(int distance) {
        if(maxDistance >= distance) {
            System.out.printf("Transformer %s ran %d kilometers\n", model, distance);
            return true;
        } else {
            System.out.printf("Transformer %s dropped out of the race\n", model);
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if(maxHeight >= height) {
            System.out.printf("Transformer %s jumped %d meters high\n", model, height);
            return true;
        } else {
            System.out.printf("Transformer %s dropped out of the race\n", model);
            return false;
        }
    }
}
