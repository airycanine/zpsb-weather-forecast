package pl.qbawalat.weather.api.location.search;

import pl.qbawalat.weather.api.WorldWeatherOnlineApi;
import pl.qbawalat.weather.api.constants.Constants;
import pl.qbawalat.weather.api.location.search.xml.model.Data;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class LocationSearch extends WorldWeatherOnlineApi {

    public LocationSearch() {
        super();
        apiEndPoint = Constants.LOCATION_API_ENDPOINT;
    }

    public Data callAPI(String query) throws JAXBException {
        return getLocationSearchData(getInputStream(apiEndPoint + query));
    }

    private Data getLocationSearchData(InputStream is) throws JAXBException {

        // create JAXB context and initializing Marshaller
        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        // this will create Java object - Data from the XML response

        return (Data) jaxbUnmarshaller.unmarshal(is);
    }

}

