package com.javarush.test.level26.lesson15.big01.exception;

import java.io.IOException;

/**
 * Created by SUSTAVOV on 04.01.2017.
 */
public class InterruptOperationException extends IOException {
    public InterruptOperationException() {
    }

    public InterruptOperationException(String message) {
        super(message);
    }
}
