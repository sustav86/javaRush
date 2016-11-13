package com.javarush.test.level14.lesson06.home01;


/**
 * Created by SUSTAVOV on 06.09.15.
 */
public class RussianHen extends Hen{

        @Override
        public int getCountOfEggsPerMonth() {
            return 5;
        }

        @Override
        public String getDescription() {
            return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";

    }
}
