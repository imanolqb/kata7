package software.ulpgc.moneycalc.View;

import software.ulpgc.moneycalc.Commands.Command;
import software.ulpgc.moneycalc.Interfaces.CurrencyDialog;
import software.ulpgc.moneycalc.Interfaces.MoneyDialog;
import software.ulpgc.moneycalc.Interfaces.MoneyDisplay;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;
    private Map<String, Command> commands = new HashMap<>();

    public MainFrame() throws HeadlessException {
        setTitle("Money Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // COMPONENTES RELACIONADOS CON LA MONEDA
        JPanel currencyPanel = new JPanel();
        currencyPanel.setLayout(new BoxLayout(currencyPanel, BoxLayout.X_AXIS));
        currencyPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        currencyPanel.add(new JLabel("From: "));

        SwingMoneyDialog moneyDialog1 = new SwingMoneyDialog();
        moneyDialog = moneyDialog1;
        currencyPanel.add(moneyDialog1);

        // COMPONENTES RELACIONADOS CON TARGET
        JPanel targetPanel = new JPanel();
        targetPanel.setLayout(new BoxLayout(targetPanel, BoxLayout.X_AXIS));
        targetPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        targetPanel.add(new JLabel("To: "));

        SwingCurrencyDialog targetDialog = new SwingCurrencyDialog();
        currencyDialog = targetDialog;
        targetPanel.add(targetDialog);

        // BOTÓN DE CAMBIO
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        buttonPanel.add(createChangeButton());

        // PANEL RESULTADO
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        resultPanel.setBorder(new EmptyBorder(5, 5, 20, 5));

        SwingMoneyDisplay moneyDisplay1 = new SwingMoneyDisplay();
        moneyDisplay = moneyDisplay1;
        resultPanel.add(moneyDisplay1);

        // AGREGAR LOS PANELES
        add(currencyPanel);
        add(targetPanel);
        add(buttonPanel);
        add(resultPanel);
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    private Component createChangeButton() {
        JButton button = new JButton("Change");
        button.addActionListener(e -> {
            try {
                commands.get("change").execute();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        return button;
    }

    public void add(String name, Command command) {
        commands.put(name, command);
    }
}
