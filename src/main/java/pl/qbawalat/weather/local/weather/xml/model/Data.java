package pl.qbawalat.weather.local.weather.xml.model;

import pl.qbawalat.weather.local.weather.xml.model.data.CurrentCondition;
import pl.qbawalat.weather.local.weather.xml.model.data.Request;
import pl.qbawalat.weather.local.weather.xml.model.data.Weather;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    public CurrentCondition current_condition;
    Request request;
    Weather weather;

    Data() {
    }

    ;
}