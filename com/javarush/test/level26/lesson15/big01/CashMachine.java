package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by SUSTAVOV on 03.01.2017.
 */
public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Operation operation;
        do {
            try {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } catch (InterruptOperationException e) {
                ConsoleHelper.writeMessage("Buy, my dear friend!");
                break;
            }

        } while (operation != Operation.EXIT);

    }
}
