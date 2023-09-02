package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common_en");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        try {
            String string = bis.readLine();
            if ("exit".equals(string.toLowerCase())) throw new InterruptOperationException();
            return string;
        } catch (IOException e) {
            return null;
        }
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        do {
            String currencyCode = readString();
            if (currencyCode != null && currencyCode.trim().length() == 3) {
                return currencyCode.toUpperCase();
            }
            writeMessage(res.getString("invalid.data"));
        } while (true);
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        do {
            String[] digits = Objects.requireNonNull(readString()).split(" ");
            if (digits.length == 2) {
                try {
                    if (Integer.parseInt(digits[0]) > 0 && Integer.parseInt(digits[1]) > 0) {
                        return digits;
                    }
                } catch (NumberFormatException e) {
                }
            }
            writeMessage(res.getString("invalid.data"));
        } while (true);
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        writeMessage("\t1 - " + res.getString("operation.INFO"));
        writeMessage("\t2 - " + res.getString("operation.DEPOSIT"));
        writeMessage("\t3 - " + res.getString("operation.WITHDRAW"));
        writeMessage("\t4 - " + res.getString("operation.EXIT"));
        do {
            int operation = Integer.parseInt(Objects.requireNonNull(readString()));
            if (operation >= 0 && operation < 5) {
                return Operation.getAllowableOperationByOrdinal(operation);
            }
            writeMessage(res.getString("invalid.data"));
        } while (true);
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }
}
