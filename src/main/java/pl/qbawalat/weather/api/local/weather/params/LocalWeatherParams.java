package pl.qbawalat.weather.api.local.weather.params;

import pl.qbawalat.weather.api.WwoApiRootParams;

public class LocalWeatherParams extends WwoApiRootParams {
    public String extra;
    public String num_of_days = "1";        //required
    public String date;
    public String fx = "yes";
    public String cc;                    //default "yes"
    public String includeLocation;        //default "no"
    public String format;                //default "xml"
    public String show_comments = "no";
    public String callback;
    public String key;                    //required
    public String q;                    //required

    public LocalWeatherParams(String key) {
        num_of_days = "1";
        show_comments = "no";
        this.key = key;
    }

    public LocalWeatherParams setQ(String q) {
        this.q = q;
        return this;
    }

    public LocalWeatherParams setNumOfDays(String num_of_days) {
        this.num_of_days = num_of_days;
        return this;
    }

    public String getNum_of_days() {
        return num_of_days;
    }
}
