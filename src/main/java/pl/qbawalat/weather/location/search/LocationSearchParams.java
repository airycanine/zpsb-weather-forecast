package pl.qbawalat.weather.location.search;

import pl.qbawalat.weather.WwoApiRootParams;

public class LocationSearchParams extends WwoApiRootParams {
    String query;                    //required
    String num_of_results = "1";
    String timezone;
    String popular;
    String format;                //default "xml"
    String key;                    //required

    public LocationSearchParams(String key) {
        num_of_results = "1";
        this.key = key;
    }
//
//    public LocationSearchParams setQuery(String query) {
//        this.query = query;
//        return this;
//    }
//
//    LocationSearchParams setNumOfResults(String num_of_results) {
//        this.num_of_results = num_of_results;
//        return this;
//    }
//
//    Params setTimezone(String timezone) {
//        this.timezone = timezone;
//        return this;
//    }
//
//    Params setPopular(String popular) {
//        this.popular = popular;
//        return this;
//    }
//
//    Params setFormat(String format) {
//        this.format = format;
//        return this;
//    }
//
//    Params setKey(String key) {
//        this.key = key;
//        return this;
//    }
}

