package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by SUSTAVOV on 08.09.15.
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    private Singleton() {

    }
}
