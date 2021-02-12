package pl.qbawalat.weather.api;

import java.io.InputStream;
import java.net.URL;

public class WwoApi {
    private static final String FREE_API_KEY = "e4561ecc74254973981164247211801";
    public String key;
    public String apiEndPoint;

    public WwoApi() {
        key = FREE_API_KEY;
    }

    public InputStream getInputStream(String url) {
        InputStream inputStream = null;

        try {
            inputStream = (new URL(url)).openConnection().getInputStream();
        } catch (Exception e) {
            System.out.println("Błąd podczas otwarcia połączenia z WWO API:" + e);
        }

        return inputStream;
    }
}