package com.javarush.test.level19.lesson10.bonus02;

import java.io.IOException;

/**
 * Created by ukr-sustavov on 17.12.2015.
 */
public class Solution
{
    public static void main(String[] args) throws IOException {

        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("H4.txt");

        fileConsoleWriter.write("Проверка  String:");

        fileConsoleWriter.write(1234);

        char[] buff = "Проверка char buff:".toCharArray();

        fileConsoleWriter.write(buff);

        fileConsoleWriter.write(buff, 3, 5);

        fileConsoleWriter.write("Проверка String обрезка:", 1, 6);

        fileConsoleWriter.flush();
        fileConsoleWriter.close();
    }
}
