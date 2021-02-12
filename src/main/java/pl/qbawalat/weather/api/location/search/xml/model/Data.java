package pl.qbawalat.weather.api.location.search.xml.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "search_api")
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    private Result result;

    Data() {
    }

    public Result getResult() {
        return result;
    }
}
