package pl.qbawalat.weather.location.search;

import pl.qbawalat.weather.WwoApi;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.InputStream;

public class LocationSearch extends WwoApi {
    //	public static final String FREE_API_ENDPOINT = "http://api.worldweatheronline.com/free/v1/search.ashx";
//	public static final String PREMIUM_API_ENDPOINT = "http://api.worldweatheronline.com/free/v1/search.ashx";
    private static final String FREE_API_ENDPOINT = "http://api.worldweatheronline.com/premium/v1/search.ashx";

    public LocationSearch() {
        super();

        apiEndPoint = FREE_API_ENDPOINT;
    }

    public Data callAPI(String query) {
        return getLocationSearchData(getInputStream(apiEndPoint + query));
    }

    private Data getLocationSearchData(InputStream is) {
        Data location = null;

        try {
            // create JAXB context and initializing Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // this will create Java object - Data from the XML response
            location = (Data) jaxbUnmarshaller.unmarshal(is);

            if (LOGD) {
                System.out.println(location.result.areaName);
                System.out.println(location.result.country);
                System.out.println(location.result.region);
            }

        } catch (JAXBException e) {
            // some exception occured
            e.printStackTrace();
        }

        return location;
    }

    @XmlRootElement(name = "search_api")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Data {
        Result result;

        Data() {
        }

        ;
    }

    @XmlRootElement(namespace = "com.example.javawwo.LocalWeather.Data")
    @XmlAccessorType(XmlAccessType.FIELD)
    static class Result {
        String areaName;
        String country;
        String region;
        String latitude;
        String longitude;
        String population;
        String weatherUrl;
        TimeZone timezone;

        Result() {
        }

        ;
    }

    @XmlRootElement(namespace = "com.example.javawwo.LocalWeather.Data")
    @XmlAccessorType(XmlAccessType.FIELD)
    static class TimeZone {
        String offset;

        TimeZone() {
        }

        ;
    }
}

