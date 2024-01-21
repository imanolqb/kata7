package software.ulpgc.moneycalc.Interfaces;

import software.ulpgc.moneycalc.Swing.Currency;
import software.ulpgc.moneycalc.Swing.ExchangeRate;

import java.io.IOException;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to);
    // void setURL(Currency from, Currency to);
}
