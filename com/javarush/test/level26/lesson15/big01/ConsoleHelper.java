package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by SUSTAVOV on 03.01.2017.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException{
        String in = "";

        try {
            in = reader.readLine();

        }catch (IOException ex) {
            writeMessage("Wrong choice");
        }

        if (in.toLowerCase().equals("exit")) {
            throw new InterruptOperationException();

        }

        return in;
    }

    public static String askCurrencyCode() throws InterruptOperationException{
        writeMessage("Enter the currency code.");
        String s = readString();
        while (s.length() != 3)
        {
            writeMessage("The code must contain three characters!");
            s = readString();
        }
        return s.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
        String valueAndAmount;
        String[] result;
        writeMessage("Input nominal and amount: " + currencyCode);

        while (true) {
            valueAndAmount = readString();
            if (valueAndAmount.matches("\\d+ \\d+")) {
                result = valueAndAmount.split(" ");
                if(result[0].equals("0") || result[1].equals("0")){
                    writeMessage("Invalid nominal and amount, retry.");
                    continue;
                }
                return result;
            } else{
                writeMessage("Invalid nominal and amount, retry.");
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        Operation operation;
        while (true) {
            writeMessage("Choose operation: 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
            try {
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
                break;
            }catch (IllegalArgumentException ex) {
                writeMessage("Wrong choice");
            }

        }
        return operation;
    }
}
