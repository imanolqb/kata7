package software.ulpgc.moneycalc.Swing;

public record Currency(String code, String name, String symbol) {

    @Override
    public String toString() {
        return code + "-" + name + " " + symbol;
    }
}
