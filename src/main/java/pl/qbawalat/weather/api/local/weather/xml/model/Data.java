package pl.qbawalat.weather.api.local.weather.xml.model;

import pl.qbawalat.weather.api.local.weather.xml.model.data.CurrentCondition;
import pl.qbawalat.weather.api.local.weather.xml.model.data.Request;
import pl.qbawalat.weather.api.local.weather.xml.model.data.Weather;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    private CurrentCondition current_condition;
    private Request request;
    private Weather[] weather;

    Data() {
    }

    public CurrentCondition getCurrent_condition() {
        return current_condition;
    }


    @Override
    public String toString() {
        return "Data{" + "current_condition=" + current_condition.toString() + '}';
    }

    public void setCurrent_condition(CurrentCondition current_condition) {
        this.current_condition = current_condition;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }
}