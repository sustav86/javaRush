package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SUSTAVOV on 06.01.2017.
 */
public final class CommandExecutor {
    private static Map<Operation, Command> operationCommandMap = new HashMap<>();
    static {
        operationCommandMap.put(Operation.INFO, new InfoCommand());
        operationCommandMap.put(Operation.DEPOSIT, new DepositCommand());
        operationCommandMap.put(Operation.WITHDRAW, new WithdrawCommand());
        operationCommandMap.put(Operation.EXIT, new ExitCommand());
    }

    public static final void execute(Operation operation) throws InterruptOperationException {
        if (operationCommandMap.containsKey(operation)) {
            operationCommandMap.get(operation).execute();
        }
    }

    private CommandExecutor() {
    }
}
