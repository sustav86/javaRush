package com.javarush.test.level26.lesson15.big01;

import java.util.ArrayList;
import java.util.Collection;
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

    public static Collection getAllCurrencyManipulators() {
        return new ArrayList<CurrencyManipulator>(currencyManipulator.values());
    }

//    public static Map<String, CurrencyManipulator> getAllCurrencyManipulators() {
//        return currencyManipulator;
//    }

//    public static boolean hasMoney() {
//        return !currencyManipulator.isEmpty();
//    }

    private CurrencyManipulatorFactory() {
    }
}
