package pl.qbawalat.weather.api.local.weather;

import pl.qbawalat.weather.api.WwoApi;
import pl.qbawalat.weather.api.local.weather.xml.model.Data;
import pl.qbawalat.weather.api.local.weather.xml.model.data.CurrentCondition;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class LocalWeather extends WwoApi {
    private static final String FREE_API_ENDPOINT = "http://api.worldweatheronline.com/premium/v1/weather.ashx";

    public LocalWeather() {
        super();
        apiEndPoint = FREE_API_ENDPOINT;
    }

    public Data callAPI(String query) throws JAXBException {
        return getLocalWeatherData(getInputStream(apiEndPoint + query));
    }

    private Data getLocalWeatherData(InputStream is) throws JAXBException {
        Data weather = null;

        // create JAXB context and initializing Marshaller
        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        // this will create Java object - Data from the XML response
        weather = (Data) jaxbUnmarshaller.unmarshal(is);

        if (LOGD) {
            CurrentCondition cc = weather.getCurrent_condition();
//                System.out.println(cc.getTemp_C());
//                System.out.println(cc.getWeatherIconUrl());
//                System.out.println(cc.getWeatherIconUrl());
        }


        return weather;
    }


}

