package pl.qbawalat.weather.local.weather.params;

import pl.qbawalat.weather.WwoApiRootParams;

public class LocalWeatherParams extends WwoApiRootParams {
    public String q;                    //required
    public String extra;
    public String num_of_days = "1";        //required
    public String date;
    public String fx = "no";
    public String cc;                    //default "yes"
    public String includeLocation;        //default "no"
    public String format;                //default "xml"
    public String show_comments = "no";
    public String callback;
    public String key;                    //required

    public LocalWeatherParams(String key) {
        num_of_days = "1";
        fx = "no";
        show_comments = "no";
        this.key = key;
    }

    public LocalWeatherParams setQ(String q) {
        this.q = q;
        return this;
    }

    LocalWeatherParams setExtra(String extra) {
        this.extra = extra;
        return this;
    }

    LocalWeatherParams setNumOfDays(String num_of_days) {
        this.num_of_days = num_of_days;
        return this;
    }

    LocalWeatherParams setDate(String date) {
        this.date = date;
        return this;
    }

    LocalWeatherParams setFx(String fx) {
        this.fx = fx;
        return this;
    }

    LocalWeatherParams setCc(String cc) {
        this.cc = cc;
        return this;
    }

    LocalWeatherParams setIncludeLocation(String includeLocation) {
        this.includeLocation = includeLocation;
        return this;
    }

    LocalWeatherParams setFormat(String format) {
        this.format = format;
        return this;
    }

    LocalWeatherParams setShowComments(String showComments) {
        this.show_comments = showComments;
        return this;
    }

    LocalWeatherParams setCallback(String callback) {
        this.callback = callback;
        return this;
    }

    LocalWeatherParams setKey(String key) {
        this.key = key;
        return this;
    }
}
