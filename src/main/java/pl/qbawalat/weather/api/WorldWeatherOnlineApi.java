package pl.qbawalat.weather.api;

import java.io.InputStream;
import java.net.URL;

public class WorldWeatherOnlineApi {
    protected String apiEndPoint;

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