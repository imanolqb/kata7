package software.ulpgc.moneycalc.View;

import software.ulpgc.moneycalc.Interfaces.MoneyDisplay;
import software.ulpgc.moneycalc.Swing.Money;

import javax.swing.*;
import java.text.DecimalFormat;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {
    private final JLabel resultLabel;
    private final JLabel valueLabel;

    public SwingMoneyDisplay() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.resultLabel = new JLabel("Result: ");
        this.valueLabel = new JLabel();
        add(resultLabel);
        add(valueLabel);
    }


    @Override
    public void show(Money money) {
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        String formattedValue = decimalFormat.format(money.amount());
        valueLabel.setText(formattedValue + money.currency().symbol());
    }
}
