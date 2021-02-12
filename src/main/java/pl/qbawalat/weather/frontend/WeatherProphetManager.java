package pl.qbawalat.weather.frontend;

import pl.qbawalat.weather.api.local.weather.xml.model.Data;
import pl.qbawalat.weather.api.location.search.LocationSearch;

import javax.xml.bind.JAXBException;
import java.util.Scanner;

public class WeatherProphetManager {

    private final WeatherService weatherService = new WeatherService("Szczecin");
    private final WeatherInfoPrinter weatherInfoPrinter = new WeatherInfoPrinter();

    public void run() {

        boolean weatherForecastModeActive = true;
        boolean configurationModeActive = true;

//        LocalWeather localWeather = new LocalWeather();
//        LocalWeatherParams localWeatherParams = new LocalWeatherParams(localWeather.key);
//        localWeatherParams.setQ(Utils.getIP());

        int days = 1;
        Scanner inputScanner = new Scanner(System.in);
//        String query = localWeatherParams.getQueryString(LocalWeatherParams.class);
//        pl.qbawalat.weather.api.local.weather.xml.model.Data weatherInfo = null;

        System.out.println("Witaj w Proroku Pogody! Co powinienem przewidzieć?");
        System.out.println("Prognoza dla Twojej lokalizacji:");

        LocationSearch locationSearch = new LocationSearch();
//        var locationInfo = locationSearch.callAPI(query);


        while (configurationModeActive) {
            System.out.println("Czy chcesz skonfigurować proroka pogody? [T/N]");
            String userInputConfig = inputScanner.nextLine();
            if (userInputConfig.equalsIgnoreCase("T")) {
                while (!userInputConfig.equals("0")) {
                    System.out.println("Co zmienić?\n1. Lokalizację\n2. Ilość dni\n0. Nic, chcę poznać pogodę!");
                    userInputConfig = inputScanner.nextLine();
                    switch (userInputConfig) {
                        case "1" -> {
                            System.out.println("Podaj lokalizację:");
                            weatherService.setLocalWeatherParamsLocation(inputScanner.nextLine());
                        }
                        case "2" -> {
                            System.out.println("Podaj ilość dni do przewidzenia:");
                            weatherService.setLocalWeatherParamsDays(inputScanner.nextLine());
                        }
                        default -> {
                            System.out.println("Sprawdzam pogodę...");
                        }
                    }

                    if (userInputConfig.equalsIgnoreCase("T")) {
                        System.out.println("Podaj lokalizację:");
                        weatherService.setLocalWeatherParamsLocation(inputScanner.nextLine());
                    }

                }
            }

            try {
                System.out.println("Aktualna lokalizacja:\n" + weatherService.getLocationInfo());
                while (weatherForecastModeActive) {
                    Data weatherInfo = null;
                    weatherInfo = weatherService.predictWeather();
                    System.out.println("Prognoza na następne " + days + " dni.");
                    System.out.println(
                            "---------------------------------------------------------------------------------------\nCo sprawdzić?");
                    System.out.println(
                            "    0.Ogólny opis\n    1. Temperatura\n    2. Opady\n    7. Wszystkie informacje\n    8. Konfiguracja\n    9. Koniec psot");

                    String userInput = inputScanner.nextLine();
                    switch (userInput) {
                        case "0" -> weatherInfoPrinter.printFullDescription(weatherInfo);
                        case "1" -> weatherInfoPrinter.printTemperatureInfo(weatherInfo);
                        case "7" -> weatherInfoPrinter.printAllWeatherInfo(weatherInfo);
                        case "8" -> showConfig();
                        case "9" -> quit();
                        default -> handleWrongInput(weatherInfo);
                    }
                    weatherForecastModeActive = !userInput.equals("9");
                    configurationModeActive = !userInput.equals("9");
                }
            } catch (JAXBException e) {
                System.out.println("Wystapil blad, podano niepoprawną lokalizację." + e);
            }
//            String userInput = inputScanner.nextLine();
//            switch (userInput) {
//                case "0" -> printFullDescription(weatherService.predictWeather());
//                case "1" -> printTemperatureInfo(weatherInfo);
//                case "7" -> printAllWeatherInfo(weatherInfo);
//                case "8" -> showConfig();
//                case "9" -> {
//                    configurationModeActive = false;
//                }
//                default -> handleWrongInput(weatherInfo);
//            }

//            activateWeatherForecastMode(weatherForecastModeActive, days, inputScanner);
        }


    }

    static void showConfig() {
        System.out.println("Niepoprawna wartość. Wybierz jeszcze raz");
    }

    static void handleWrongInput(pl.qbawalat.weather.api.local.weather.xml.model.Data weatherInfo) {
        System.out.println("Niepoprawna wartość. Wybierz jeszcze raz");
    }

    static void quit() {
        System.out.println("Przechodzę do konfiguracji lokalizacji.");
    }


}
