package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.*;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {

        PrintStream consoleOut = System.out;

        ByteArrayOutputStream myOutputStream = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOutputStream));

        testString.printSomething();

        System.setOut(consoleOut);

        StringBuffer stringBuffer = new StringBuffer();

        String[] ss = myOutputStream.toString().split(System.lineSeparator());

        for (int i = 0; i < ss.length; i++)
        {
            stringBuffer.append(ss[i]);
            stringBuffer.append(System.lineSeparator());
            if ((i + 1) % 2 == 0)
            {
                stringBuffer.append("JavaRush - курсы Java онлайн");
                stringBuffer.append(System.lineSeparator());
            }


        }

        System.out.println(stringBuffer);
    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");

        }
    }
}
