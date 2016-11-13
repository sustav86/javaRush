package com.javarush.test.level14.lesson06.home01;

/**
 * Created by SUSTAVOV on 06.09.15.
 */
public class UkrainianHen extends Hen {

    @Override
    public int getCountOfEggsPerMonth() {
        return 50;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
