package com.javarush.test.level30.lesson02.task01;

import java.math.BigInteger;

/* Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        if (s.contains("b")) {
            return String.valueOf(Integer.parseInt(s.substring(s.indexOf("b")+1), 2));
        }

        return String.valueOf(Integer.decode(s));
    }
}
