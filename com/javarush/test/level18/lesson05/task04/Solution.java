package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
//        FileInputStream inputStream = new FileInputStream(args[0]);
//        FileOutputStream outputStream = new FileOutputStream(args[1]);

        if (inputStream.available() > 0) {
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            int bufferLength = buffer.length;
            for (int i = 0; i < bufferLength / 2; i++) {
//                buffer[i] ^= buffer[bufferLength - i - 1];
//                buffer[bufferLength - i - 1] ^= buffer[i];
//                buffer[i] ^= buffer[bufferLength - i - 1];

                buffer[bufferLength - i - 1] ^= ( buffer[i] ^= buffer[bufferLength - i - 1]);
                buffer[i] ^= buffer[bufferLength - i - 1];

//                buffer[i] = (byte)(buffer[i] + buffer[bufferLength - i - 1]);
//                buffer[bufferLength - i - 1] = (byte)(buffer[i] - buffer[bufferLength - i - 1]);
//                buffer[i] = (byte)(buffer[i] - buffer[bufferLength - i - 1]);
            }

            outputStream.write(buffer, 0, count);
        }

        outputStream.close();
        inputStream.close();
        reader.close();

    }
}
