package model;

import controller.Keyboard;
import input.CardIn;
import output.CardKeeper;
import output.CashOut;
import output.Printer;
import view.Display;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by mmishanin on 11.03.2016.
 */
public class MainSystem {

    boolean flagExit = false;
    CashKeeper cashKeeper = new CashKeeper();
    CardKeeper cardKeeper = new CardKeeper();
    CashOut cashout = new CashOut();
    Keyboard keyboard = new Keyboard();
    Display display = new Display();
    CardIn cardIn = new CardIn();
    Printer printer = new Printer();



    private double getBalanceFromBank(){
        return Bank.balance;
    }

    private void reduceBalanceInBank(double val){
        Bank.balance -= val;
    }

    public void loopSystem(Card inputCard) throws IOException{

        cardIn.getCard(inputCard);
        if (!cardIn.checkCard()) {
            cardIn.giveCard();
            return;
        }

        int chance = 3;
        display.displayInfo("Enter a Password: ");
        while (chance > 0) {
            if (!keyboard.getPass()) {
                chance--;
                if (chance == 0){
                    display.displayInfo("Incorrect password 3 times.");
                    cardKeeper.addCard(cardIn.giveCardToCardKeeper());
                    return;
                }
                display.displayInfo("Incorrect password. Try again:");
            } else break;
        }

        double balance = 0.0;
        while (!flagExit) {
            display.displayMenu();
            int command = keyboard.readCommand();
            switch (command) {
                case 1:
                    balance = getBalanceFromBank();
                    display.displayInfo("Your balance: " + balance);
                    break;
                case 2:
                    display.displayInfo("Enter sum divisible 50 rub:");
                    int neededCash = keyboard.getSum();
                    while (neededCash%50 != 0){
                        display.displayInfo("Please, enter sum divisible 50 rub:");
                        neededCash = keyboard.getSum();
                    }
                    balance = getBalanceFromBank();
                    if (balance > neededCash) {
                        double c = cashKeeper.giveCash(neededCash);
                        if (c != 0.0) {
                            cashout.giveCash(c);
                            reduceBalanceInBank(neededCash);
                            display.displayInfo("Do you want to print a cheque?");
                            display.displayInfo("1. Yes");
                            display.displayInfo("2. No");
                            int ans = keyboard.readCommand();
                            if (ans == 1){
                                balance = getBalanceFromBank();
                                try {
                                    printer.writeCheque(neededCash, balance);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            display.displayInfo("Not enought cash in CashKeeper");
                        }
                    } else {
                        display.displayInfo("Not enought cash in account");
                    }
                    break;
                case 3:
                    cardIn.giveCard();
                    flagExit = true;
                    break;
            }

        }
    }
}
