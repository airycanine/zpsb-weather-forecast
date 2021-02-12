package pl.qbawalat.weather.frontend;

import pl.qbawalat.weather.api.local.weather.LocalWeather;
import pl.qbawalat.weather.api.local.weather.params.LocalWeatherParams;
import pl.qbawalat.weather.api.local.weather.xml.model.Data;
import pl.qbawalat.weather.api.location.search.LocationSearch;

import javax.xml.bind.JAXBException;

public class WeatherService {
    private final LocalWeather localWeather;
    private final LocationSearch locationSearch;
    private final LocalWeatherParams localWeatherParams;

    public WeatherService(String weatherLocation) {
        this.localWeather = new LocalWeather();
        this.locationSearch = new LocationSearch();
        this.localWeatherParams = new LocalWeatherParams(localWeather.key);
        this.localWeatherParams.setQ(weatherLocation);
    }

    public Data predictWeather() throws JAXBException {
        return localWeather.callAPI(getQuery());
    }

    public String getLocationInfo() throws JAXBException {
        var locationInfo = locationSearch.callAPI(getQuery());
        return ("    Lokalizacja: " + locationInfo.getResult().getCountry() + ", " + locationInfo.getResult()
                .getAreaName()).concat("\n    Położenie geograficzne: " + locationInfo.getResult()
                .getLatitude() + ", " + locationInfo.getResult().getLongitude());

    }

    public String getNumberOfDays() {
        return this.localWeatherParams.getNum_of_days();
    }

    public void setLocalWeatherParamsLocation(String location) {
        this.localWeatherParams.setQ(location);
    }

    public void setLocalWeatherParamsDays(String numberOfDays) {
        this.localWeatherParams.setNumOfDays(numberOfDays);
    }

    private String getQuery() {
        return localWeatherParams.getQueryString(LocalWeatherParams.class);
    }
}
