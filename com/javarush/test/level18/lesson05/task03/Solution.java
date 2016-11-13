package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        int countFirst = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream1 = new FileOutputStream(reader.readLine());
        FileOutputStream outputStream2 = new FileOutputStream(reader.readLine());



        if (inputStream.available() > 0) {
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            if (count % 2 != 0) countFirst = count / 2 + 1;
            else countFirst = count / 2;

            outputStream1.write(buffer, 0, countFirst);
            outputStream2.write(buffer, countFirst, count-countFirst);

        }

        outputStream2.close();
        outputStream1.close();
        inputStream.close();
        reader.close();

    }
}
