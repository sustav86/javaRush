package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Map<String, Integer> hashMonth = new HashMap<String, Integer>();
        hashMonth.put("january",1);
        hashMonth.put("february",2);
        hashMonth.put("march",3);
        hashMonth.put("april",4);
        hashMonth.put("may",5);
        hashMonth.put("june",6);
        hashMonth.put("july",7);
        hashMonth.put("august",8);
        hashMonth.put("september",9);
        hashMonth.put("october",10);
        hashMonth.put("november",11);
        hashMonth.put("december",12);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameMonth = reader.readLine();
        System.out.println(nameMonth + " is " + hashMonth.get(nameMonth.toLowerCase()) + " month");

    }

}
