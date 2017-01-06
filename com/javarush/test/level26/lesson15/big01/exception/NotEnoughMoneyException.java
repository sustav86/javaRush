package com.javarush.test.level26.lesson15.big01.exception;

import java.io.IOException;

/**
 * Created by SUSTAVOV on 04.01.2017.
 */
public class NotEnoughMoneyException extends IOException {
    public NotEnoughMoneyException() {
    }

    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
