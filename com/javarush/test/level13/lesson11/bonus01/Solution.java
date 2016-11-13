package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        File file = new File(reader.readLine());

        if (file.exists()) {
            Scanner readerFile = new Scanner(new FileReader(file));
            List<Integer> array = new ArrayList<Integer>();
            while (readerFile.hasNextInt()) {
                int simbol = readerFile.nextInt();
                if (simbol %  2 == 0)
                    array.add(simbol);
            }
            Collections.sort(array);
            for (Integer i: array) {
                System.out.println(i);
            }

        }
        reader.close();

    }
}
