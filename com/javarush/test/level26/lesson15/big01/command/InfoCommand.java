package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Collection;


/**
 * Created by SUSTAVOV on 06.01.2017.
 */
class InfoCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
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
            ConsoleHelper.writeMessage("No money available.");
        }
    }
}
