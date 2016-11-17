package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by SUSTAVOV on 14.11.2016.
 */
public class Hippodrome {

    public static Hippodrome game;

    private ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                move();
                print();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }

    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        System.out.println();
        System.out.println();

    }

    public Horse getWinner() {
        Horse fasterHorse = null;
        for (Horse horse : horses) {
           fasterHorse = fasterHorse != null ? fasterHorse.getDistance() > horse.getDistance() ? fasterHorse : horse : horse;
        }
        return fasterHorse;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {

        game = new Hippodrome();
        Horse horse1 = new Horse("buka", 3, 0);
        Horse horse2 = new Horse("muka", 3, 0);
        Horse horse3 = new Horse("shuks", 3, 0);
        ArrayList<Horse> horses = game.getHorses();
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        game.run();
        game.printWinner();


    }


}
