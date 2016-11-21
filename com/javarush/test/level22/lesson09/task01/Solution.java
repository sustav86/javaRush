package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution
{
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args)
    {
        String second = "";
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();

        try
        {
            stringBuilder.append(new String(Files.readAllBytes(Paths.get("oro.txt")), "WINDOWS-1251").replaceAll("\n"," ").replaceAll("\r", ""));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String[] arrayWords = stringBuilder.toString().split(" ");


        for (Pair pair : result) {
            System.out.println(pair.first + " " + pair.second);

        }


    }

    public static class Pair
    {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString()
        {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
