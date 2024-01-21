package software.ulpgc.moneycalc.View;

import software.ulpgc.moneycalc.Interfaces.CurrencyDialog;
import software.ulpgc.moneycalc.Interfaces.MoneyDialog;
import software.ulpgc.moneycalc.Swing.Currency;
import software.ulpgc.moneycalc.Swing.Money;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {
    private final JTextField amount;
    private CurrencyDialog currencyDialog;

    public SwingMoneyDialog() {
        this.setLayout(new FlowLayout());
        this.add(new JLabel("Amount: "));
        this.amount = createAmountField();
        this.add(amount);
    }

    private JTextField createAmountField() {
        JTextField result = new JTextField();
        result.setColumns(8);
        return result;
    }


    @Override
    public MoneyDialog define(List<Currency> currencies) {
        add(createCurrencyDialog(currencies));
        return this;
    }

    private Component createCurrencyDialog(List<Currency> currencies) {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        dialog.define(currencies);
        this.currencyDialog = dialog;
        return dialog;
    }

    @Override
    public Money get() {
        try {
            double moneyAmount;
            moneyAmount = Double.parseDouble(amount.getText());
            return new Money(moneyAmount, currencyDialog.get());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
