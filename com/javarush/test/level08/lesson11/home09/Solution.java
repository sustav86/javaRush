package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isDateOdd("MAY 2 2013"));
    }

    public static boolean isDateOdd(String date)
    {
        Date myDate = new Date(date);

        Date yearStart = new Date();
        yearStart.setHours(0);
        yearStart.setMinutes(0);
        yearStart.setSeconds(0);
        yearStart.setDate(1);
        yearStart.setMonth(0);
        yearStart.setYear(myDate.getYear());
        System.out.println(yearStart);

        long msTime = myDate.getTime() - yearStart.getTime();
        long msDay = 24 * 60 * 60 * 1000;

        return !((int)(msTime / msDay) % 2 == 0);
    }
}
