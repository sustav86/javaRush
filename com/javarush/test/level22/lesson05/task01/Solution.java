package com.javarush.test.level22.lesson05.task01;

import java.util.Arrays;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        String[] arrayString = string.split(" ");
        if (arrayString.length < 5) throw new TooShortStringException();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < 5; i++)
        {
            stringBuilder.append(arrayString[i]+ " ");
        }
        return stringBuilder.toString().substring(0, stringBuilder.length()-1);
    }

    public static class TooShortStringException extends Exception {

        public TooShortStringException()
        {
            System.out.println("String too short!");
        }

    }

    public static void main(String[] args)
    {
        try
        {
            System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        }
        catch (TooShortStringException e)
        {
            e.printStackTrace();
        }

    }
}
