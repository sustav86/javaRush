package com.javarush.test.level14.lesson08.bonus01;

import java.io.*;
import java.util.*;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        }
        catch (Exception ex)
        {
            exceptions.add(ex);
        }

        //2
        int i = 0;
        int[] nArray = new int[5];

        while (true)
        {
            try
            {
                nArray[i] = i;
            }
            catch (Exception ex)
            {
                exceptions.add(ex);
                break;
            }
            i++;
        }

        //3
        Object szStr[] = new String[10];

        try
        {
            szStr[0] = new Character('*');
        }
        catch (Exception ex)
        {
            exceptions.add(ex);
        }

        //4
        Object x = new Integer(0);

        try
        {

            System.out.println((String) x);

        }
        catch (Exception ex)
        {
            exceptions.add(ex);
        }

        //5
        int[] nNegArray;

        try
        {
            nNegArray = new int[-5];
        }
        catch (Exception ex)
        {
            exceptions.add(ex);
        }

        //6
        Solution sol = null;

        try
        {

            sol.toString();

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        //7
        Collection integers = new HashSet(10);
        Random random = new Random();

        for (int j = 0; j < 10; ++j)
            integers.add(random.nextInt());

        Collection unmodifiableCollection = Collections.unmodifiableCollection(integers);

        try
        {
            unmodifiableCollection.add(random.nextInt());
        }
        catch (Exception ex)
        {
            exceptions.add(ex);
        }


        try
        {
            PrintWriter out = new PrintWriter(new File("c:/11.rxr"));
            out.print("sdfsdfsdf");

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }


        try
        {
            ArrayList<String> array = new ArrayList<>(-10);

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }


        String szShortString = "123";

        try
        {
            char chr = szShortString.charAt(10);
        }
        catch (Exception ex)
        {
            exceptions.add(ex);
        }


    }
}
