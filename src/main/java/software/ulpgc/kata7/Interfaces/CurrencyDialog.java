package software.ulpgc.moneycalc.Interfaces;

import software.ulpgc.moneycalc.Swing.Currency;

import java.util.List;

public interface CurrencyDialog {
    CurrencyDialog define(List<Currency> currencies);
    Currency get();
}
