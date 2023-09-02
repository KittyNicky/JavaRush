package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");


    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String cardNumber = ConsoleHelper.readString();
            String pinCode = ConsoleHelper.readString();

            if (cardNumber == null || (cardNumber = cardNumber.trim()).length() != 12 ||
                    pinCode == null || (pinCode = pinCode.trim()).length() != 4) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            } else {
                try {
                    if (validCreditCards.containsKey(cardNumber) && pinCode.equals(validCreditCards.getString(cardNumber))) {
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumber));
                        break;
                    } else {
                        ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));
                        ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    }
                } catch (NumberFormatException e) {
                    ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                }
            }
        }
    }
}
