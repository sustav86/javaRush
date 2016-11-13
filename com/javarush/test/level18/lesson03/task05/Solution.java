package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        List<Integer> byteList = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());

        while (inputStream.available() > 0)
        {
            byteList.add(inputStream.read());
        }

        Collections.sort(byteList);

        for (int i = 0; i < byteList.size(); i++) {
            if (i == 0 || (i != 0 && (byteList.get(i-1) != byteList.get(i)))) System.out.println(byteList.get(i));

        }
    }


}
