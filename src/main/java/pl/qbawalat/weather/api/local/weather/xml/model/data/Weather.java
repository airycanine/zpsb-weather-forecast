package pl.qbawalat.weather.api.local.weather.xml.model.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "com.example.javawwo.LocalWeather.Data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Weather {
    private String date;
    private String tempMaxC;
    private String tempMaxF;
    private String tempMinC;
    private String tempMinF;
    private String windspeedMiles;
    private String windspeedKmph;
    private String winddirection;
    private String weatherCode;
    private String weatherIconUrl;
    private String weatherDesc;
    private String precipMM;

    Weather() {
    }


    public String getDate() {
        return date;
    }

    public String getTempMaxC() {
        return tempMaxC;
    }

    public String getTempMaxF() {
        return tempMaxF;
    }

    public String getTempMinC() {
        return tempMinC;
    }

    public String getTempMinF() {
        return tempMinF;
    }

    public String getWindspeedMiles() {
        return windspeedMiles;
    }

    public String getWindspeedKmph() {
        return windspeedKmph;
    }

    public String getWinddirection() {
        return winddirection;
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public String getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public String getPrecipMM() {
        return precipMM;
    }

    @Override
    public String toString() {
        return "Weather{" + "date='" + date + '\'' + ", tempMaxC='" + tempMaxC + '\'' + ", tempMaxF='" + tempMaxF + '\'' + ", tempMinC='" + tempMinC + '\'' + ", tempMinF='" + tempMinF + '\'' + ", windspeedMiles='" + windspeedMiles + '\'' + ", windspeedKmph='" + windspeedKmph + '\'' + ", winddirection='" + winddirection + '\'' + ", weatherCode='" + weatherCode + '\'' + ", weatherIconUrl='" + weatherIconUrl + '\'' + ", weatherDesc='" + weatherDesc + '\'' + ", precipMM='" + precipMM + '\'' + '}';
    }
}
