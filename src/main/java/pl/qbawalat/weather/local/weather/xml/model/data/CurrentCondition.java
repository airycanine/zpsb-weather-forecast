package pl.qbawalat.weather.local.weather.xml.model.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "com.example.javawwo.LocalWeather.Data")
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrentCondition {
    private String observation_time;
    private String weatherCode;
    private String weatherDesc;
    private String windspeedMiles;
    private String windspeedKmph;
    private String winddirDegree;
    private String winddir16Point;
    private String precipMM;
    private String humidity;
    private String visibility;
    private String pressure;
    private String cloudcover;
    private String temp_C;
    private String weatherIconUrl;

    CurrentCondition() {
    }

    public String getObservation_time() {
        return observation_time;
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public String getWindspeedMiles() {
        return windspeedMiles;
    }

    public String getWindspeedKmph() {
        return windspeedKmph;
    }

    public String getWinddirDegree() {
        return winddirDegree;
    }

    public String getWinddir16Point() {
        return winddir16Point;
    }

    public String getPrecipMM() {
        return precipMM;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getPressure() {
        return pressure;
    }

    public String getCloudcover() {
        return cloudcover;
    }

    public String getTemp_C() {
        return temp_C;
    }

    public String getWeatherIconUrl() {
        return weatherIconUrl;
    }
}
