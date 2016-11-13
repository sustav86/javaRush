package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        RandomAccessFile fileOutputStream = new RandomAccessFile(reader.readLine(), "rw");
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

//        RandomAccessFile fileOutputStream = new RandomAccessFile(args[0], "rw");
//        FileInputStream fileInputStream = new FileInputStream(args[1]);

        if (fileInputStream.available() > 0)
        {
            byte[] buffer = new byte[fileInputStream.available()];
            byte[] bufferOut = new byte[(int) fileOutputStream.length()];

            fileInputStream.read(buffer);
            fileOutputStream.read(bufferOut);

            fileOutputStream.seek(0);
            fileOutputStream.write(buffer);

            fileOutputStream.write(bufferOut);

        }

        fileInputStream.close();
        fileOutputStream.close();
        reader.close();

    }
}
