package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());

        int i = 1;
        while (fileReader.ready()) {
            if (i % 2 == 0) {
                fileWriter.write(fileReader.read());
            }else {

                fileReader.read();


            }

            i += 1;

        }

        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
