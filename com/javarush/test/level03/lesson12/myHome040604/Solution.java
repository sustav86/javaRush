package com.javarush.test.level03.lesson12.myHome040604;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by ukr-sustavov on 20.04.2015.
 */
public class Solution {

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String Name1 = reader.readLine();
        String Name2 = reader.readLine();

        if(Name1.equals(Name2)) {
            System.out.println("Имена идентичны");
        }else {
            if(Name1.length() == Name2.length()) {
                System.out.println("Длины имен равны");
            }
        }

    }
}
