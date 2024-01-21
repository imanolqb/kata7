package software.ulpgc.moneycalc.Commands;

import software.ulpgc.moneycalc.Interfaces.CurrencyDialog;
import software.ulpgc.moneycalc.Interfaces.ExchangeRateLoader;
import software.ulpgc.moneycalc.Interfaces.MoneyDialog;
import software.ulpgc.moneycalc.Interfaces.MoneyDisplay;
import software.ulpgc.moneycalc.Swing.*;

import java.io.IOException;

public class ExchangeRateCommand implements Command {
    private final MoneyDisplay moneyDisplay;
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;

    public ExchangeRateCommand(MoneyDisplay moneyDisplay, MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeRateLoader) {
        this.moneyDisplay = moneyDisplay;
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.get();
        Currency to = currencyDialog.get();
        // exchangeRateLoader.setURL(money.currency(), to);
        ExchangeRate exchangeRate = exchangeRateLoader.load(money.currency(), to);
        Money result = new Money((double) (money.amount()*exchangeRate.rate()), to);
        moneyDisplay.show(result);
    }
}
