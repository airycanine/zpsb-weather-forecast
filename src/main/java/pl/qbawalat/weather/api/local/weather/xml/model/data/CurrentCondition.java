package pl.qbawalat.weather.api.local.weather.xml.model.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
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

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public String getWindspeedKmph() {
        return windspeedKmph;
    }

    public String getHumidity() {
        return humidity;
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

    @Override
    public String toString() {
        return "CurrentCondition{" + "observation_time='" + observation_time + '\'' + ", weatherCode='" + weatherCode + '\'' + ", weatherDesc='" + weatherDesc + '\'' + ", windspeedMiles='" + windspeedMiles + '\'' + ", windspeedKmph='" + windspeedKmph + '\'' + ", winddirDegree='" + winddirDegree + '\'' + ", winddir16Point='" + winddir16Point + '\'' + ", precipMM='" + precipMM + '\'' + ", humidity='" + humidity + '\'' + ", visibility='" + visibility + '\'' + ", pressure='" + pressure + '\'' + ", cloudcover='" + cloudcover + '\'' + ", temp_C='" + temp_C + '\'' + ", weatherIconUrl='" + weatherIconUrl + '\'' + '}';
    }
}
