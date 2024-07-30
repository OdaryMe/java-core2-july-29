package ru.geekbrains.java_core2.lessons.l1_oop.homework1;

public class Homework1 {
    public static void main(String[] args) {

        RunJumping[] runJumpings = {
          new Goblin("Kris", 25, 3),
          new Goblin("Ant", 30, 5),
          new Transformer("M-65C", 500, 5),
          new Transformer("3B-25R", 1000, 20),
          new Penguin("Vasya", 2, 1),
          new Penguin("Reiky", 1, 1)
        };

        Obstacle[] obstacles = {
          new Treadmill(1),
          new Barrier(2),
          new Treadmill(50),
          new Barrier(3),
          new Treadmill(200),
          new Barrier(5)
        };

        for (RunJumping runJumping : runJumpings) {
            for (Obstacle obstacle : obstacles) {
                if (obstacle instanceof Treadmill) {
                    boolean runResult = runJumping.run(((Treadmill) obstacle).getSize());
                    if(!runResult) {
                        break;
                    }
                } else if (obstacle instanceof Barrier) {
                    boolean jumpResult = runJumping.jump(((Barrier) obstacle).getSize());
                    if(!jumpResult) {
                        break;
                    }
                }
            }
        }
    }
}
