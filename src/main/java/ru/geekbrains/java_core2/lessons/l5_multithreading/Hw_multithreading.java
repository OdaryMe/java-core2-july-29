package ru.geekbrains.java_core2.lessons.l5_multithreading;

import java.util.Arrays;

/*Создать масив, заполнить его флоатами 1.0 и вычислить каждое значение по формуле.
Вывести время вычисления при работе в одном потоке. И время, если мы сначала делим массив на два,
вычисляем значения в параллельных потоках, склеиваем массив обратно.*/

public class Hw_multithreading {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        float val = 1.0f;
        float[] arr1 = getArr(val);
        float[] arr2 = getArr(val);

        firstMethod(arr1);
        secondMethod(arr2);
        System.out.println("Checking. Arrays are equal: " + Arrays.equals(arr1, arr2));
    }

    private static void secondMethod(float[] arr2) {

        long startTime = System.currentTimeMillis();
        float[] half1 = Arrays.copyOf(arr2, HALF);
        float[] half2 = Arrays.copyOfRange(arr2, HALF, SIZE);

        Thread firstHalfThread = new Thread(() -> computArr(half1, 0));
        firstHalfThread.start();
        Thread secondHalfThread = new Thread(() -> computArr(half2, HALF));
        secondHalfThread.start();

        try {
            firstHalfThread.join();
            secondHalfThread.join();
        } catch (InterruptedException e) {
            System.err.println("Sorry, you were interrupted");
            e.printStackTrace();
        }

        System.arraycopy(half1, 0, arr2, 0, HALF);
        System.arraycopy(half2, 0, arr2, HALF, HALF);

        long finishTime = System.currentTimeMillis();
        System.out.println("Two threads time: " + (finishTime - startTime) + " ms.");
    }

    private static void firstMethod(float[] arr1) {
        long startTime = System.currentTimeMillis();
        computArr(arr1, 0);
        long finishTime = System.currentTimeMillis();
        System.out.println("One thread time: " + (finishTime - startTime) + " ms.");
    }

    private static void computArr(float [] arr, int offset) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + offset) / 5) * Math.cos(0.2f + (i + offset) / 5) * Math.cos(0.4f + (i + offset) / 2));
        }
    }

    private static float[] getArr(float val) {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, val);
        return arr;
    }
}
