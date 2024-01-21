package software.ulpgc.moneycalc.Main;

import software.ulpgc.moneycalc.APIloader.FixerCurrencyLoader;
import software.ulpgc.moneycalc.APIloader.FixerExchangeRateLoader;
import software.ulpgc.moneycalc.Commands.ExchangeRateCommand;
import software.ulpgc.moneycalc.Interfaces.*;
import software.ulpgc.moneycalc.View.MainFrame;
import software.ulpgc.moneycalc.Swing.Currency;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        System.out.println("Hola mundo!!");
        */
        MainFrame frame = new MainFrame();
        ClassLoader classLoader = Main.class.getClassLoader();
        CurrencyLoader currencyLoader = new FixerCurrencyLoader();
        List<Currency> currencyList = currencyLoader.load();
        MoneyDialog moneyDialog = frame.getMoneyDialog().define(currencyList);
        CurrencyDialog currencyDialog = frame.getCurrencyDialog().define(currencyList);
        MoneyDisplay moneyDisplay = frame.getMoneyDisplay();
        ExchangeRateLoader exchangeRateLoader = new FixerExchangeRateLoader();
        frame.add("change", new ExchangeRateCommand(moneyDisplay, moneyDialog, currencyDialog, exchangeRateLoader));
        frame.setVisible(true);
    }
}