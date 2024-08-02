package ru.geekbrains.java_core2.lessons.l2_exceptions;

import java.util.Arrays;

public class Experience {
    public static void main(String[] args) {
        String[][] myArr = {
                {"-65", "eight", "308", "1"},
                {"-4", "-16", "3", "62"},
                {"89", "18", "228", "-280"},
                {"156", "0", "-887", "11"}
        };
        for (int i = 0; i < myArr.length; i++) {
            for (int j = 0; j < myArr[i].length; j++) {
             if(!checkArrData(myArr)) {
                 var message = String.format("Invalid cell %d:%d%n", i, j);
                 throw new MyArrayDataException(message);
             }
            }
        }
    }

    private static boolean checkArrData(String[][] myArr) {
        for (int i = 0; i < myArr.length; i++) {
            String s = Arrays.toString(myArr[i]);

            char[] charArr = s.toCharArray();
            for (int j = 0; j < charArr.length; j++) {
                if (charArr[j] != '0' || charArr[j] != '1' || charArr[j] != '2' || charArr[j] != '3' ||
                        charArr[j] != '4' || charArr[j] != '5' || charArr[j] != '6' || charArr[j] != '7' ||
                        charArr[j] != '8' || charArr[j] != '9') {
                    return false;
                }
            }
        }return true;
    }
}
