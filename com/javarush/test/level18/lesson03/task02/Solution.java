package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int nextByte = 0;
        int minByte = Integer.MAX_VALUE;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());

        while (inputStream.available() > 0) {
            nextByte = inputStream.read();
            if (minByte > nextByte) minByte = nextByte;

        }

        inputStream.close();
        reader.close();

        System.out.println(minByte);
    }
}
