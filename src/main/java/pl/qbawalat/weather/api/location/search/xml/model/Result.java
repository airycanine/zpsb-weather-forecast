package pl.qbawalat.weather.api.location.search.xml.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Result {
    //    TimeZone timezone;
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
        return "Result{" + "areaName='" + areaName + '\'' + ", country='" + country + '\'' + ", region='" + region + '\'' + ", latitude='" + latitude + '\'' + ", longitude='" + longitude + '\'' + ", population='" + population + '\'' + ", weatherUrl='" + weatherUrl + '\'' + '}';
    }


    public String getAreaName() {
        return areaName;
    }


    public String getCountry() {
        return country;
    }


    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }


}
