package com.javarush.test.ddd;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * Created by SUSTAVOV on 13.11.2016.
 */
public class Sol {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("index1.txt")));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder.toString());
    }
}
