package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        if (args.length != 3) return;

        if ("-e".equals(args[0])) encrypt(args[1], args[2]);
        else if ("-d".equals(args[0])) decrypt(args[1], args[2]);

//        System.out.println("sdfsdfsdf");

    }

    public static void encrypt(String fileName, String fileOutputName) throws IOException
    {

        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;

        try
        {
            fileInputStream = new FileInputStream(fileName);
        }
        catch (FileNotFoundException e)
        {

            System.out.println("File input not found");
            return;
        }

        try
        {
            fileOutputStream = new FileOutputStream(fileOutputName);
        }
        catch (FileNotFoundException e)
        {

            System.out.println("File output not found");
            return;
        }

        if (fileInputStream.available() > 0) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);

            for (int i = 0; i < buffer.length; i++) {
                buffer[i] += 1;
            }

            fileOutputStream.write(buffer, 0, buffer.length);

        }

    }

    public static void decrypt(String fileName, String fileOutputName) throws IOException
    {

        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;

        try
        {
            fileInputStream = new FileInputStream(fileName);
        }
        catch (FileNotFoundException e)
        {

            System.out.println("File input not found");
            return;
        }

        try
        {
            fileOutputStream = new FileOutputStream(fileOutputName);
        }
        catch (FileNotFoundException e)
        {

            System.out.println("File output not found");
            return;
        }

        if (fileInputStream.available() > 0) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);

            for (int i = 0; i < buffer.length; i++) {
                buffer[i] -= 1;
            }

            fileOutputStream.write(buffer, 0, buffer.length);

        }



    }

}
