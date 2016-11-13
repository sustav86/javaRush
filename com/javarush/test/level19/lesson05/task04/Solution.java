package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        byte[] buffer = null;

        BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInput = new FileInputStream(readerFileName.readLine());
        FileOutputStream fileOutput = new FileOutputStream(readerFileName.readLine());


        if (fileInput.available() > 0)
        {
            buffer = new byte[fileInput.available()];
            fileInput.read(buffer);

        }

       for (int i = 0; i < buffer.length; i++) {

           if (buffer[i] == 46) buffer[i] = 33;

        }

        fileOutput.write(buffer);

        readerFileName.close();
        fileInput.close();
        fileOutput.close();
    }
}
