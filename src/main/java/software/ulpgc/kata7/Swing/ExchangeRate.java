package software.ulpgc.moneycalc.Swing;

import java.util.Date;

public record ExchangeRate(Currency from, Currency to, Date date, double rate) {
}
