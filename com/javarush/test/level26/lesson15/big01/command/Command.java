package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by SUSTAVOV on 06.01.2017.
 */
interface Command {
    void execute() throws InterruptOperationException;
}
