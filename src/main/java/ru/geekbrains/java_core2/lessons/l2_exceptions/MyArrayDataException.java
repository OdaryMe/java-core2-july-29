package ru.geekbrains.java_core2.lessons.l2_exceptions;

public class MyArrayDataException extends NumberFormatException {

    public MyArrayDataException() {
        super();
    }

    public MyArrayDataException(String message) {
        super(message);
    }
}
