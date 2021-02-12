package pl.qbawalat.weather.api.location.search.xml.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "com.example.javawwo.LocalWeather.Data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Result {
    TimeZone timezone;
    private String areaName;
    private String country;
    private String region;
    private String latitude;
    private String longitude;
    private String population;
    private String weatherUrl;

    Result() {
    }

    @Override
    public String toString() {
        return "Result{" + "areaName='" + areaName + '\'' + ", country='" + country + '\'' + ", region='" + region + '\'' + ", latitude='" + latitude + '\'' + ", longitude='" + longitude + '\'' + ", population='" + population + '\'' + ", weatherUrl='" + weatherUrl + '\'' + ", timezone=" + timezone + '}';
    }


    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getWeatherUrl() {
        return weatherUrl;
    }

    public void setWeatherUrl(String weatherUrl) {
        this.weatherUrl = weatherUrl;
    }

    public TimeZone getTimezone() {
        return timezone;
    }

    public void setTimezone(TimeZone timezone) {
        this.timezone = timezone;
    }
}
