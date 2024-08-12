package ru.geekbrains.java_core2.lessons.l5_multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Создать масив, заполнить его флоатами 1.0 и вычислить каждое значение по формуле.
Вывести время вычисления при работе в одном потоке. И время, если мы сначала делим массив на два,
вычисляем значения в параллельных потоках, склеиваем массив обратно.*/

public class Hw_multithreading {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        float val = 1.0f;

        firstMethod(val);
        secondMethod(val);
    }

    private static void secondMethod(float val) {
        float[] arr = getArr(val);
        long startTime = System.currentTimeMillis();
        float[] arr1 = Arrays.copyOf(arr, HALF);
        float[] arr2 = Arrays.copyOfRange(arr, HALF, SIZE);

        Thread firstHalfThread = new Thread(() -> computArr(arr1));
        firstHalfThread.start();
        Thread secondHalfThread = new Thread(() -> computArr(arr2));
        secondHalfThread.start();

        try {
            firstHalfThread.join();
            secondHalfThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List list = new ArrayList(Arrays.asList(arr1));
        list.addAll(Arrays.asList(arr2));
        Object[] mergedArr = list.toArray();
        long finishTime = System.currentTimeMillis();
        System.out.println("Two threads time: " + (finishTime - startTime) + " ms.");
    }

    private static void firstMethod(float val) {
        float[] arr = getArr(val);
        long startTime = System.currentTimeMillis();
        computArr(arr);
        long finishTime = System.currentTimeMillis();
        System.out.println("One thread time: " + (finishTime - startTime) + " ms.");
    }

    private static float[] computArr(float [] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }

    private static float[] getArr(float val) {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, val);
        return arr;
    }
}
