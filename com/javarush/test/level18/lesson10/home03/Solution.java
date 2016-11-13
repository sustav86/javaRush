package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
        FileInputStream fileInputStream1 = new FileInputStream(reader.readLine());
        FileInputStream fileInputStream2 = new FileInputStream(reader.readLine());


        if (fileInputStream1.available() > 0) {
            byte[] buffer = new byte[fileInputStream1.available()];
            fileInputStream1.read(buffer);
            fileOutputStream.write(buffer, 0, buffer.length);
        }

        if (fileInputStream2.available() > 0) {
            byte[] buffer = new byte[fileInputStream2.available()];
            fileInputStream2.read(buffer);
            fileOutputStream.write(buffer, 0, buffer.length);
        }

        fileInputStream1.close();
        fileInputStream2.close();
        fileOutputStream.close();
        reader.close();

    }
}
