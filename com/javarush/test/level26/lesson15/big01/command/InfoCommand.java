package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * Created by SUSTAVOV on 06.01.2017.
 */
class InfoCommand implements Command {
    @Override
    public void execute() {
//        if (!CurrencyManipulatorFactory.hasMoney()) {
//            System.out.println("No money available.");
//        } else {
//            Map<String, CurrencyManipulator> currencyManipulatorMap = CurrencyManipulatorFactory.getAllCurrencyManipulators();
//            for (Map.Entry<String, CurrencyManipulator> entry : currencyManipulatorMap.entrySet()) {
//                if (entry.getValue().hasMoney()) {
//                    System.out.println(entry.getKey() + " - " + entry.getValue().getTotalAmount());
//                } else {
//                    System.out.println("No money available.");
//                }
//            }
//        }
//        Map<String, CurrencyManipulator> currencyManipulatorMap = CurrencyManipulatorFactory.getAllCurrencyManipulators();
//        if (currencyManipulatorMap.isEmpty()) {
//            System.out.println("No money available.");
//        } else {
//            for (Map.Entry<String, CurrencyManipulator> entry : currencyManipulatorMap.entrySet()) {
//                if (entry.getValue().hasMoney()) {
//                    System.out.println(entry.getKey() + " - " + entry.getValue().getTotalAmount());
//                } else {
//                    System.out.println("No money available.");
//                }
//            }
//        }

        Collection<CurrencyManipulator> currencyManipulatorMap = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        int count = 0;
        for (CurrencyManipulator currencyManipulator : currencyManipulatorMap) {
            if (currencyManipulator.hasMoney() && currencyManipulator.getTotalAmount() > 0) {
                System.out.println(currencyManipulator.getCurrencyCode() + " - " + currencyManipulator.getTotalAmount());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No money available.");
        }
    }
}
