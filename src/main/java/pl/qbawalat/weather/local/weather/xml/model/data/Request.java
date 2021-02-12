package pl.qbawalat.weather.local.weather.xml.model.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "com.example.javawwo.LocalWeather.Data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Request {
    private String type;
    private String query;

    Request() {
    }

    ;
}
