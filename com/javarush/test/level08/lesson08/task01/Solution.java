package com.javarush.test.level08.lesson08.task01;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> set = new HashSet<String>();
        set.add("Лира");
        set.add("Лиr");
        set.add("Ла");
        set.add("Лираr");
        set.add("Лираsdf");
        set.add("Лираfgh");
        set.add("Лираg");
        set.add("Лираh");
        set.add("Лираj");
        set.add("Лираk");
        set.add("Лираl");
        set.add("Лираu");
        set.add("Лираqd");
        set.add("Лираw");
        set.add("Лираe");
        set.add("Лираr2");
        set.add("Лираc");
        set.add("Лираv");
        set.add("Лираb");
        set.add("Лираn222");

        return set;
    }
}
