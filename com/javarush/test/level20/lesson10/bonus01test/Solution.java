package com.javarush.test.level20.lesson10.bonus01test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static int[][] degreesTable = new int[10][10];

    static {

        for (int i = 1; i < degreesTable.length; i++) {
            for (int j = 1; j < degreesTable.length; j++) {
                degreesTable[i][j] = (int)Math.pow(i,j);
            }
        }
    }

    public static void main(String args[]) throws IOException{

        long memoryStart = Runtime.getRuntime().freeMemory();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the highest border of number:");
        int number = Integer.parseInt(reader.readLine());

        int[] allNumbers = getNumbers(number);

        for (int i : allNumbers) {
            System.out.print(i + " ");
        }

        System.out.println("");

//        long memoryEnd = Runtime.getRuntime().freeMemory();
//        long memoTaken = memoryStart - memoryEnd;
//        System.out.println(memoTaken + " byte");

    }

    public static int[] getNumbers(int N) {

        int[] result;
        List<Integer> tempArray = new ArrayList<>();
        int degree;
        int sum;
        int n;

        for (int i = 1; i < N ; i++) {
            n = i;
            sum = 0;
            degree = (int) Math.ceil(Math.log10(n));

            while(n > 0) {
                if (sum > N) break;
                sum += degreesTable[n % 10][degree];
                n /= 10;
            }

            if (sum > N) {
//                break;
            } else if (sum == i) {
                System.out.print(sum + " ");
            }

        }

        tempArray.add(1);
        tempArray.add(0);

        result = new int[tempArray.size()];

        for (int i = tempArray.size()-1; i >= 0; i--) {
            result[tempArray.size()-1-i] = tempArray.get(i);
        }

        return result;
    }
}


//    public static int[] getNumbers(int N) {
//
//        int[] result;
//        List<Integer> tempArray = new ArrayList<>();
//        int degree;
//        int sum;
//        int n;
//
//        for (int i = N; i > 0 ; i--) {
//            n = i;
//            sum = 0;
//            degree = (int) Math.ceil(Math.log10(n));
//
//            while(n > 0) {
//                if (sum > N) break;
//                sum += degreesTable[n % 10][degree];
//                n /= 10;
//            }
//
//            if (sum == i) {
//                tempArray.add(i);
//            }
//
//        }
//
//        tempArray.add(1);
//        tempArray.add(0);
//
//        result = new int[tempArray.size()];
//
//        for (int i = tempArray.size()-1; i >= 0; i--) {
//            result[tempArray.size()-1-i] = tempArray.get(i);
//        }
//
//        return result;
//    }
//}}
