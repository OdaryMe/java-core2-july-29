package ru.geekbrains.java_core2.lessons.l2_exceptions;

import java.util.Arrays;

public class Homework9 {
    public static void main(String[] args) {
        String[][] myArr = {
                {"-65", "8", "308", "1025"},
                {"-1074", "-16", "3", "62"},
                {"89", "18", "228", "-280"},
                {"156", "0", "-887", "11"}
        };

        String[][] notMyArr = {
                {"1", "8", "308", "1025"},
                {"1459", "776", "3", "62"},
                {"89", "18", "9"},
                {"156", "65", "5", "11"}
        };

        String[][] crookedArr = {
                {"-6", "8", "308", "1025"},
                {"1459", "776", "3", "62"},
                {"89", "18", "228", "1511"},
                {"156", "0", "two", "11"}
        };

        try {
            parseString(myArr);
            parseString(notMyArr);
            parseString(crookedArr);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Something went wrong. Check your array");
        }

    }

    public static void parseString (String[][] arr) {
        int summ = 0;
        int[][] set = new int[4][4];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr.length != 4 || arr[i].length != 4) {
                  throw new MyArraySizeException("Wrong Array Size");
                }
                try {
                    set[i][j] = Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    String message = "Invalid cell " + i + ":" + j;
                    throw new MyArrayDataException(message);
                }
                summ += set[i][j];
            }
        }
        System.out.println(summ);
    }
}
