package software.ulpgc.moneycalc.APIloader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import software.ulpgc.moneycalc.Interfaces.ExchangeRateLoader;
import software.ulpgc.moneycalc.Swing.Currency;
import software.ulpgc.moneycalc.Swing.ExchangeRate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FixerExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try {
            double rate = toRate(loadJson(from, to));
            return new ExchangeRate(from, to, null, rate);
        } catch (IOException e) {
            return null;
        }
    }

    private double toRate(String json) {
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        JsonObject dataObject = jsonObject.getAsJsonObject("data");
        String key = dataObject.entrySet().iterator().next().getKey();
        return dataObject.getAsJsonPrimitive(key).getAsDouble();
    }

    private String loadJson(Currency from, Currency to) throws IOException {
        String link = "https://api.freecurrencyapi.com/v1/latest?apikey=fca_live_tpLhNLU4R8iDs8DYzzQzkNZJa2STjJtC0dKEJWze&currencies=" + to.code() + "&base_currency=" + from.code();
        // String link = "https://api.freecurrencyapi.com/v1/latest?apikey=fca_live_tpLhNLU4R8iDs8DYzzQzkNZJa2STjJtC0dKEJWze&currencies=MXN&base_currency=EUR";
        try (InputStream is = new URL(link).openStream()) {
            return new String(is.readAllBytes());
        }
    }
}
