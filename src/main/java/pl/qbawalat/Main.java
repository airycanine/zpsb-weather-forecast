package pl.qbawalat;

import pl.qbawalat.weather.frontend.WeatherProphetManager;

public class Main {
    public static void main(String[] args) {
        WeatherProphetManager weatherProphetManager = new WeatherProphetManager();
        weatherProphetManager.run();
    }
}
