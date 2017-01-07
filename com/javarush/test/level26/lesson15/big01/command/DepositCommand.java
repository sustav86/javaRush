package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

/**
 * Created by SUSTAVOV on 06.01.2017.
 */
class DepositCommand implements Command {
    @Override
    public void execute() {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        String[] valueQuantityBanknotes = ConsoleHelper.getValidTwoDigits(currencyCode);
        currencyManipulator.addAmount(Integer.parseInt(valueQuantityBanknotes[0]), Integer.parseInt(valueQuantityBanknotes[1]));

    }
}
