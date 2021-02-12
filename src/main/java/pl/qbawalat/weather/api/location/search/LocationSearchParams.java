package pl.qbawalat.weather.api.location.search;

import pl.qbawalat.weather.api.WwoApiRootParams;

public class LocationSearchParams extends WwoApiRootParams {
    String query;                    //required
    String num_of_results = "5";
    String timezone;
    String popular;
    String format;                //default "xml"
    String key;                    //required

    public LocationSearchParams(String key) {
        num_of_results = "5";
        this.key = key;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getNum_of_results() {
        return num_of_results;
    }

    public void setNum_of_results(String num_of_results) {
        this.num_of_results = num_of_results;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getPopular() {
        return popular;
    }

    public void setPopular(String popular) {
        this.popular = popular;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

