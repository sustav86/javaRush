package com.javarush.test.level22.lesson05.home01;

public class TooShortStringSecondThreadException extends RuntimeException
{
    public TooShortStringSecondThreadException()
    {
        super();
    }

    public TooShortStringSecondThreadException(String message)
    {
        super(message);
    }

    public TooShortStringSecondThreadException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public TooShortStringSecondThreadException(Throwable cause)
    {
        super(cause);
    }
}
