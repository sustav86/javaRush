package com.javarush.test.level14.lesson08.home09;

/**
 * Created by ukr-sustavov on 07.09.2015.
 */
public class USD extends Money
{
    @Override
    public String getCurrencyName()
    {
        return "USD";
    }

    public USD(double amount)
    {
        super(amount);
    }
}
