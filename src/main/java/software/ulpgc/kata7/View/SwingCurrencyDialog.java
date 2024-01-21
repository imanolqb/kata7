package software.ulpgc.moneycalc.View;

import software.ulpgc.moneycalc.Interfaces.CurrencyDialog;
import software.ulpgc.moneycalc.Swing.Currency;

import javax.swing.*;
import java.util.List;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {
    private List<Currency> currencies;
    private JComboBox<Currency> currencyJComboBox;


    @Override
    public CurrencyDialog define(List<Currency> currencies) {
        this.currencies = currencies;
        add(currencyJComboBox = currencySelector(currencies));
        return this;
    }

    private JComboBox<Currency> currencySelector(List<Currency> currencies) {
        JComboBox<Currency> result = new JComboBox<>();
        for (Currency currency : currencies) {
            result.addItem(currency);
        }
        return result;
    }

    @Override
    public Currency get() {
        return (Currency) currencyJComboBox.getSelectedItem();
    }
}
