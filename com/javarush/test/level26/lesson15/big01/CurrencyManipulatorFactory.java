package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SUSTAVOV on 04.01.2017.
 */
public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> currencyManipulator = new HashMap<>();
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (currencyManipulator.containsKey(currencyCode)) {
            return currencyManipulator.get(currencyCode);
        }else {
            currencyManipulator.put(currencyCode, new CurrencyManipulator(currencyCode));
        }

        return currencyManipulator.get(currencyCode);
    }

    private CurrencyManipulatorFactory() {
    }
}
