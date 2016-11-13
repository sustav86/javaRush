package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        String prefix = "part";
        String outFile;
        Map<String, String> filesList = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        outFile = str.substring(0, str.lastIndexOf("."));
        while (!"end".equals(str)) {
            filesList.put(str.substring(str.lastIndexOf(".", str.length()) + 1), str);
            str = scanner.nextLine();
        }

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(outFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FileInputStream fileInputStream = null;
        for (int i = 1; i < 10000; i++) {
            String fileName = filesList.get(prefix + i);

            if (fileName == null) continue;

            File fileIn = new File(fileName);
            if (!fileIn.exists()) continue;

            try {
                fileInputStream = new FileInputStream(fileIn);

                byte[] buffer = new byte[fileInputStream.available()];
                // считываем буфер
                fileInputStream.read(buffer, 0, buffer.length);
                // записываем из буфера в файл
                fileOutputStream.write(buffer, 0, buffer.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        scanner.close();

        try {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
