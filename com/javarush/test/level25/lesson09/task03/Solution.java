package com.javarush.test.level25.lesson09.task03;

import java.util.ArrayList;
import java.util.List;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    List<String> throwableList = new ArrayList<>();
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        throwableList.add(e.toString());
        Throwable current = e.getCause();
        while (current != null) {
            throwableList.add(current.toString());
            current = current.getCause();
        }
        for (int i = throwableList.size()-1; i >= 0; i--) {
            System.out.println(throwableList.get(i));
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(){
            public void run(){
                try{
                    throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
                } catch (Exception e){
                    getUncaughtExceptionHandler().uncaughtException(currentThread(), e);
                }
            }
        };
        thread.setUncaughtExceptionHandler(new Solution());
        thread.start();
    }
}
