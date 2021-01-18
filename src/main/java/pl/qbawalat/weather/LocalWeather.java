package pl.qbawalat.weather;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.InputStream;

public class LocalWeather extends WwoApi {
    private static final String FREE_API_ENDPOINT = "http://api.worldweatheronline.com/premium/v1/weather.ashx";

    public LocalWeather() {
        super();
        apiEndPoint = FREE_API_ENDPOINT;
    }

    public Data callAPI(String query) {
        return getLocalWeatherData(getInputStream(apiEndPoint + query));
    }

    private Data getLocalWeatherData(InputStream is) {
        Data weather = null;

        try {
            // create JAXB context and initializing Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // this will create Java object - Data from the XML response
            weather = (Data) jaxbUnmarshaller.unmarshal(is);

            if (LOGD) {
                CurrentCondition cc = weather.current_condition;
                System.out.println(cc.temp_C);
                System.out.println(cc.weatherIconUrl);
                System.out.println(cc.weatherIconUrl);
            }
        } catch (JAXBException e) {
            // some exception occured
            e.printStackTrace();
        }

        return weather;
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Data {
        Request request;
        CurrentCondition current_condition;
        Weather weather;

        Data() {
        }

        ;
    }

    @XmlRootElement(namespace = "com.example.javawwo.LocalWeather.Data")
    @XmlAccessorType(XmlAccessType.FIELD)
    static class Request {
        String type;
        String query;

        Request() {
        }

        ;
    }

    @XmlRootElement(namespace = "com.example.javawwo.LocalWeather.Data")
    @XmlAccessorType(XmlAccessType.FIELD)
    static class CurrentCondition {
        String observation_time;
        String temp_C;
        String weatherCode;
        String weatherIconUrl;
        String weatherDesc;
        String windspeedMiles;
        String windspeedKmph;
        String winddirDegree;
        String winddir16Point;
        String precipMM;
        String humidity;
        String visibility;
        String pressure;
        String cloudcover;

        CurrentCondition() {
        }

        ;
    }

    @XmlRootElement(namespace = "com.example.javawwo.LocalWeather.Data")
    @XmlAccessorType(XmlAccessType.FIELD)
    static class Weather {
        String date;
        String tempMaxC;
        String tempMaxF;
        String tempMinC;
        String tempMinF;
        String windspeedMiles;
        String windspeedKmph;
        String winddirection;
        String weatherCode;
        String weatherIconUrl;
        String weatherDesc;
        String precipMM;

        Weather() {
        }

        ;
    }

    public class Params extends RootParams {
        String q;                    //required
        String extra;
        String num_of_days = "1";        //required
        String date;
        String fx = "no";
        String cc;                    //default "yes"
        String includeLocation;        //default "no"
        String format;                //default "xml"
        String show_comments = "no";
        String callback;
        String key;                    //required

        public Params(String key) {
            num_of_days = "1";
            fx = "no";
            show_comments = "no";
            this.key = key;
        }

        public Params setQ(String q) {
            this.q = q;
            return this;
        }

        Params setExtra(String extra) {
            this.extra = extra;
            return this;
        }

        Params setNumOfDays(String num_of_days) {
            this.num_of_days = num_of_days;
            return this;
        }

        Params setDate(String date) {
            this.date = date;
            return this;
        }

        Params setFx(String fx) {
            this.fx = fx;
            return this;
        }

        Params setCc(String cc) {
            this.cc = cc;
            return this;
        }

        Params setIncludeLocation(String includeLocation) {
            this.includeLocation = includeLocation;
            return this;
        }

        Params setFormat(String format) {
            this.format = format;
            return this;
        }

        Params setShowComments(String showComments) {
            this.show_comments = showComments;
            return this;
        }

        Params setCallback(String callback) {
            this.callback = callback;
            return this;
        }

        Params setKey(String key) {
            this.key = key;
            return this;
        }
    }
}

