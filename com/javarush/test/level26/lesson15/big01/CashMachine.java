package com.javarush.test.level26.lesson15.big01;

import java.util.Locale;

/**
 * Created by SUSTAVOV on 03.01.2017.
 */
public class CashMachine {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] valueQuantityBanknotes = ConsoleHelper.getValidTwoDigits(currencyCode);
        CurrencyManipulator currencyManipulator = new CurrencyManipulator(currencyCode);
        currencyManipulator.addAmount(Integer.parseInt(valueQuantityBanknotes[0]), Integer.parseInt(valueQuantityBanknotes[1]));
        System.out.println(currencyManipulator.getCurrencyCode());


    }
}
