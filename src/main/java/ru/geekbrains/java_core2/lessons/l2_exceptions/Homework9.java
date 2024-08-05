package ru.geekbrains.java_core2.lessons.l2_exceptions;

import java.util.Arrays;

public class Homework9 {
    public static final int ARRSIZE = 4;

    public static void main(String[] args) {

        String[][] myArr = {
                {"-65", "8", "308", "573"},
                {"-2", "-16", "3", "62"},
                {"89", "18", "228", "-280"},
                {"12", "0", "-887", "11"}
        };

        String[][] notMyArr = {
                {"1", "8", "308", "1025"},
                {"-1459", "776", "3", "62"},
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
            parseStringArrToInt(myArr);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Something went wrong. Check your array");
        }

        try {
            parseStringArrToInt(notMyArr);
        } catch (MyArraySizeException e) {
            System.out.println("Something went wrong. Check size of your array");
        }

        try {
            parseStringArrToInt(crookedArr);
        } catch (MyArrayDataException e) {
            System.out.println("Something went wrong. Check data of your array");
        }
    }

    public static void parseStringArrToInt (String[][] arr) {
        int summ = 0;
        if (arr.length != ARRSIZE) {
            throw new MyArraySizeException("Wrong Array Size");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != ARRSIZE) {
                throw new MyArraySizeException("Wrong Array Size");
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    String message = "Invalid cell " + i + ":" + j;
                    throw new MyArrayDataException(message);
                }
                summ += Integer.parseInt(arr[i][j]);
            }
        }
        System.out.println("Sum = " + summ);
    }
}
