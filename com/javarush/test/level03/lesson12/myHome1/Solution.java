package com.javarush.test.level03.lesson12.myHome1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by ukr-sustavov on 20.04.2015.
 */
public class Solution  {

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String sNum1 = reader.readLine();
        //String sNum2 = reader.readLine();
        //String sNum3 = reader.readLine();
        //String sNum4 = reader.readLine();

        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());
        int num3 = Integer.parseInt(reader.readLine());
        int num4 = Integer.parseInt(reader.readLine());

        int max1 = max(num1, num2);
        int max2 = max(num3, num4);
        if(max1 > max2) System.out.println(max1);
        else System.out.println(max2);
    }

    public static int max(int a, int b) {
        if(a > b) return a;
        else
            return b;
    }

}
