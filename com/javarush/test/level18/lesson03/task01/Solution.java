package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int nextByte = 0;
        int maxByte = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());

        while (inputStream.available() > 0) {
            nextByte = inputStream.read();
//            if (maxByte < nextByte) maxByte = nextByte;
            System.out.println(nextByte);

        }

        inputStream.close();
        reader.close();

        System.out.println(maxByte);


    }
}
