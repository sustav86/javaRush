package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.Map;

/* Люди с одинаковыми именами и/или фамилиями
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList()
    {
        Map<String, String> map = new HashMap<String, String>();

        map.put("Ф", "И");
        map.put("Ф1", "И1");
        map.put("Ф1", "И1");
        map.put("Ф3", "И3");
        map.put("Ф4", "И4");
        map.put("Ф5", "И5");
        map.put("Ф6", "И6");
        map.put("Ф7", "И7");
        map.put("Ф8", "И8");
        map.put("Ф9", "И9");

        return map;
    }

    public static void printPeopleList(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
