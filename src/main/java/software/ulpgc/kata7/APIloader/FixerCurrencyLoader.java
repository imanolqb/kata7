package software.ulpgc.moneycalc.APIloader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import software.ulpgc.moneycalc.Interfaces.CurrencyLoader;
import software.ulpgc.moneycalc.Main.Main;
import software.ulpgc.moneycalc.Swing.Currency;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FixerCurrencyLoader implements CurrencyLoader {

    @Override
    public List<Currency> load() {
        try {
            return toList(loadJson());
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private List<Currency> toList(String json) {
        List<Currency> list = new ArrayList<>();

        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        JsonObject dataObject = jsonObject.getAsJsonObject("data");

        for (String coin : dataObject.keySet()) {
            JsonObject currencyObject = dataObject.getAsJsonObject(coin);
            String code = currencyObject.get("code").getAsString();
            String name = currencyObject.get("name").getAsString();
            String symbol = currencyObject.get("symbol").getAsString();
            list.add(new Currency(code, name, symbol));
        }

        return list;
    }

    private String loadJson() throws IOException {
        URL url = new URL("https://api.freecurrencyapi.com/v1/currencies?apikey=fca_live_tpLhNLU4R8iDs8DYzzQzkNZJa2STjJtC0dKEJWze&currencies=&base_currency=MXN");
        try (InputStream is = url.openStream()) {
            return new String(is.readAllBytes());
        }
    }
}
