package software.ulpgc.moneycalc.Interfaces;

import software.ulpgc.moneycalc.Swing.Currency;
import software.ulpgc.moneycalc.Swing.Money;

import java.util.List;

public interface MoneyDialog {
    MoneyDialog define(List<Currency> currencies);
    Money get();
}
