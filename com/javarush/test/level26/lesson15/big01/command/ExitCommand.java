package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by SUSTAVOV on 06.01.2017.
 */
class ExitCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException{
        ConsoleHelper.writeMessage("Aru you sure you want to exit? <y, n>");
        if (ConsoleHelper.readString().toLowerCase().equals("y")) {
            ConsoleHelper.writeMessage("Bye");
            throw new InterruptOperationException();
        }

    }
}
