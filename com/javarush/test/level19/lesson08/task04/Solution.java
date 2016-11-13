package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {

        String operation = "";

//        BigInteger result = BigInteger.ZERO;

        Integer result = 0;

        Integer[] digit = new Integer[2];

        PrintStream consoleOut = System.out;

        ByteArrayOutputStream myOutputStream = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOutputStream));

        testString.printSomething();

        String res = myOutputStream.toString();

        System.setOut(consoleOut);

        String regEx = "\\+|\\-|\\*";

        Pattern myPattern = Pattern.compile(regEx);

        Matcher matcher = myPattern.matcher(res);

        while (matcher.find())
        {

            operation = res.substring(matcher.start(), matcher.end());

        }

        regEx = "\\d{1,30}";

        myPattern = Pattern.compile(regEx);

        matcher = myPattern.matcher(res);

        int count = 0;
        while (matcher.find())
        {

            digit[count] = Integer.parseInt(res.substring(matcher.start(), matcher.end()));

            count++;

        }

        switch (operation)
        {
            case "+":
                result = digit[0] + digit[1];
                break;
            case "-":
                result = digit[0] - digit[1];
                break;
            case "*":
                result = digit[0] * digit[1];
                break;
            default:
                break;
        }

        System.out.println(res.replaceAll(System.lineSeparator(), "") + result);


    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("35 + 4546 = ");
        }
    }
}

