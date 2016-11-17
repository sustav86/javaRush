package com.javarush.test.level22.lesson05.home01;

public class TooShortStringFirstThreadException extends RuntimeException
{
    public TooShortStringFirstThreadException()
    {
        super();
    }

    public TooShortStringFirstThreadException(String message)
    {
        super(message);
    }

    public TooShortStringFirstThreadException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public TooShortStringFirstThreadException(Throwable cause)
    {
        super(cause);
    }
}
