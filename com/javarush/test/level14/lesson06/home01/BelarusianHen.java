package com.javarush.test.level14.lesson06.home01;

/**
 * Created by SUSTAVOV on 06.09.15.
 */
public class BelarusianHen extends Hen{

    @Override
    public int getCountOfEggsPerMonth() {
        return 34;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
