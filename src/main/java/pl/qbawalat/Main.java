package pl.qbawalat;

import pl.qbawalat.weather.LocalWeather;
import pl.qbawalat.weather.LocationSearch;
import pl.qbawalat.weather.Utils;

public class Main {
    public static void main(String[] args) {
        LocalWeather lw = new LocalWeather();
        String query = (lw.new Params(lw.key)).setQ(Utils.getIP()).getQueryString(LocalWeather.Params.class);
        LocalWeather.Data weather = lw.callAPI(query);

        //get location
        LocationSearch ls = new LocationSearch();
        query = (ls.new Params(ls.key)).setQuery(Utils.getIP()).getQueryString(LocationSearch.Params.class);
        LocationSearch.Data data = ls.callAPI(query);
    }
}
