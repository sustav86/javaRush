package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashSet<Integer> hs = createSet();
        hs = removeAllNumbersMoreThan10(hs);

        for (int n : hs)
        {
            System.out.println(n);
        }
    }

    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.add(10);
        set.add(11);
        set.add(12);
        set.add(13);
        set.add(14);
        set.add(15);
        set.add(16);
        set.add(17);
        set.add(18);
        set.add(19);
        set.add(20);

        return set;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //Iterator<Integer> iterator = setinterface.iterator();

        //while (iterator.hasNext())
       // {
        //    int str = iterator.next();
        //    if (str > 10)
        //        iterator.remove();
       // }

        for (Integer n : set)
        {
            if (n.intValue() > 10)
            {
                //setinterface.remove();
            }
                //setinterface.remove(n);
        }

        return set;
    }
}
