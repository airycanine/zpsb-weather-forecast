package pl.qbawalat.weather.api.location.search;

import pl.qbawalat.weather.api.WwoApi;
import pl.qbawalat.weather.api.location.search.xml.model.Data;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class LocationSearch extends WwoApi {
    //	public static final String FREE_API_ENDPOINT = "http://api.worldweatheronline.com/free/v1/search.ashx";
//	public static final String PREMIUM_API_ENDPOINT = "http://api.worldweatheronline.com/free/v1/search.ashx";
    private static final String FREE_API_ENDPOINT = "http://api.worldweatheronline.com/premium/v1/search.ashx";

    public LocationSearch() {
        super();

        apiEndPoint = FREE_API_ENDPOINT;
    }

    public Data callAPI(String query) throws JAXBException {
        return getLocationSearchData(getInputStream(apiEndPoint + query));
    }

    private Data getLocationSearchData(InputStream is) throws JAXBException {
        Data location = null;

        // create JAXB context and initializing Marshaller
        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        // this will create Java object - Data from the XML response
        location = (Data) jaxbUnmarshaller.unmarshal(is);

        return location;
    }

}

