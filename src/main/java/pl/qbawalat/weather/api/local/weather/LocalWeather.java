package pl.qbawalat.weather.api.local.weather;

import pl.qbawalat.weather.api.WorldWeatherOnlineApi;
import pl.qbawalat.weather.api.constants.Constants;
import pl.qbawalat.weather.api.local.weather.xml.model.Data;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class LocalWeather extends WorldWeatherOnlineApi {

    public LocalWeather() {
        super();
        apiEndPoint = Constants.WEATHER_API_ENDPOINT;
    }

    public Data callAPI(String query) throws JAXBException {
        return getLocalWeatherData(getInputStream(apiEndPoint + query));
    }

    private Data getLocalWeatherData(InputStream is) throws JAXBException {
        // create JAXB context and initializing Marshaller
        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        // this will create Java object - Data from the XML response

        return (Data) jaxbUnmarshaller.unmarshal(is);
    }


}

