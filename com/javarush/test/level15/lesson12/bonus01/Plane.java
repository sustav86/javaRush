package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by SUSTAVOV on 29.09.15.
 */
public class Plane implements Flyable {

    private static int passengers;

    public Plane(int passengers) {
        this.passengers = passengers;

    }

    @Override
    public void fly() {

    }
}
