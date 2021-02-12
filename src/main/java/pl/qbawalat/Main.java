package pl.qbawalat;

import pl.qbawalat.weather.Utils;
import pl.qbawalat.weather.local.weather.LocalWeather;
import pl.qbawalat.weather.local.weather.params.LocalWeatherParams;
import pl.qbawalat.weather.local.weather.xml.model.Data;

public class Main {
    public static void main(String[] args) {
        LocalWeather localWeather = new LocalWeather();
        LocalWeatherParams localWeatherParams = new LocalWeatherParams(localWeather.key);
        localWeatherParams.setQ(Utils.getIP());
        String query = localWeatherParams.getQueryString(LocalWeatherParams.class);
        Data data = localWeather.callAPI(query);


        //get location
//        LocationSearch ls = new LocationSearch();
//        query = (ls.new Params(ls.key)).setQuery(Utils.getIP()).getQueryString(LocationSearch.Params.class);
//        LocationSearch.Data data = ls.callAPI(query);
    }
}
