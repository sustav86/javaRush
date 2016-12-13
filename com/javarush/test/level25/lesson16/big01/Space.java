package com.javarush.test.level25.lesson16.big01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUSTAVOV on 10.12.2016.
 */
public class Space {
    private int width;
    private int height;
    private SpaceShip ship;
    private List<Rocket> rockets = new ArrayList<>();
    private List<Ufo> ufos = new ArrayList<>();
    private List<Bomb> bombs = new ArrayList<>();

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SpaceShip getShip() {
        return ship;
    }

    public List<Rocket> getRockets() {
        return rockets;
    }

    public List<Ufo> getUfos() {
        return ufos;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }

    public static void main(String[] args) {

    }
}
