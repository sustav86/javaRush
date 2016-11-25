package com.javarush.test.ddd;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by SUSTAVOV on 13.11.2016.
 */
public class Sol {
    public static void main(String[] args) {
//        StringBuilder stringBuilder = new StringBuilder();
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("index1.txt")));
//            String str;
//            while ((str = bufferedReader.readLine()) != null) {
//                stringBuilder.append(str);
//            }
//        } catch (java.io.IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(stringBuilder.toString());
//        System.out.printf("%8s", ".");
//        System.out.println(new String(new char[5]).replace("\0", "."));
        String field = "   ";
//        System.out.println(field.rem.length() == 0);

//        obj : Object = NULL;
//        Object obj = null;
//        obj : Object = null;
//        Object obj2 = 0;
//        Object obj3 = NULL;
//        Object obj4 = UNKNOWN;
        Stream<String> num = Arrays.stream("1,5".split(","));

        int f = num.mapToInt(Integer::parseInt).sum();
        System.out.println(f);
    }
}
