package ru.geekbrains.java_core2.lessons.l2_exceptions;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {

    public MyArraySizeException() {
        super();
    }

    public MyArraySizeException(String message) {
        super(message);
    }
}
