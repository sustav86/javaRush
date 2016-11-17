package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        StringBuilder stringBuilder = new StringBuilder();
//        try (Scanner scanner = new Scanner(System.in))
//        {
//            String fileName = scanner.nextLine();
//
//            try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
//            {
//                String str;
//                while ((str = br.readLine()) != null)
//                {
//                    stringBuilder.append(str);
//                }
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//
//        }
//
//        System.out.println(stringBuilder.toString());

        String content;

        try
        {
            stringBuilder.append(new String(Files.readAllBytes(Paths.get("oro.txt")), "WINDOWS-1251"));
            System.out.println(stringBuilder.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static class Pair
    {
        String first;
        String second;

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
