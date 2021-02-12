package pl.qbawalat.weather.frontend;

import pl.qbawalat.weather.api.local.weather.xml.model.Data;

public class WeatherInfoPrinter {

    public void printFullDescription(Data weatherInfo) {
        System.out.println("    Warunki:" + weatherInfo.getCurrent_condition().getWeatherDesc());
        System.out.println("    Zachmurzenie:" + weatherInfo.getCurrent_condition().getCloudcover());
        System.out.println("    Temperatura:" + weatherInfo.getCurrent_condition().getTemp_C());
        System.out.println("    Wilgotność:" + weatherInfo.getCurrent_condition().getHumidity());
        System.out.println("    Ciśnienie:" + weatherInfo.getCurrent_condition().getPressure());
        System.out.println("    Prędkość wiatru (km/h):" + weatherInfo.getCurrent_condition().getWindspeedKmph());
    }

    public void printAllWeatherInfo(Data weatherInfo) {
        System.out.println(weatherInfo.toString());
    }

    public void printTemperatureInfo(Data weatherInfo) {
        System.out.println("    Aktualna temperatura (C): " + weatherInfo.getCurrent_condition().getTemp_C());
    }


}
