package pl.qbawalat.weather.frontend;

import pl.qbawalat.weather.api.IpUtils;
import pl.qbawalat.weather.api.local.weather.xml.model.data.Weather;

import javax.xml.bind.JAXBException;
import java.util.Scanner;

public class WeatherProphetManager {

    private final WeatherService weatherService = new WeatherService(IpUtils.getIP());
    private final WeatherInfoPrinter weatherInfoPrinter = new WeatherInfoPrinter();

    public void run() {

        boolean weatherForecastModeActive = true;
        boolean appActive = true;
        Scanner inputScanner = new Scanner(System.in);
        printGreetMessage();

        while (appActive) {
            try {
                weatherForecastModeActive = configureApp(weatherForecastModeActive, inputScanner);
                System.out.println("Aktualna lokalizacja:\n" + weatherService.getLocationInfo());
                while (weatherForecastModeActive) {
                    printWeatherInfoOptions();

                    String userInput = inputScanner.nextLine();
                    var weatherInfo = weatherService.predictWeather();

                    switch (userInput) {
                        case "1" -> weatherInfoPrinter.printFullDescription(weatherInfo);
                        case "2" -> weatherInfoPrinter.printTemperatureInfo(weatherInfo);
                        case "3" -> {
                            for (Weather weatherPerDay : weatherInfo.getWeather()) {
                                weatherInfoPrinter.printWeatherInfoForNextDays(weatherPerDay);
                            }
                        }
                        case "8" -> weatherInfoPrinter.printConfigMessage();
                        case "9" -> weatherInfoPrinter.printQuitMessage();
                        default -> handleWrongInput();
                    }
                    weatherForecastModeActive = !userInput.equals("8") && !userInput.equals("9");
                    appActive = !userInput.equals("9");
                }
            } catch (JAXBException e) {
                System.out.println("Wystapil blad, podano niepoprawną lokalizację." + e);
            }
        }
    }

    private boolean configureApp(boolean weatherForecastModeActive, Scanner inputScanner) {
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
                        System.out.println("Tryb pogodynki...");
                        weatherForecastModeActive = true;
                    }
                }

                if (userInputConfig.equalsIgnoreCase("T")) {
                    System.out.println("Podaj lokalizację:");
                    weatherService.setLocalWeatherParamsLocation(inputScanner.nextLine());
                }

            }
        } else {
            weatherForecastModeActive = true;
        }
        return weatherForecastModeActive;
    }

    private void printGreetMessage() {
        System.out.println("Witaj w Proroku Pogody! Co powinienem przewidzieć?");
        System.out.println("Prognoza dla Twojej lokalizacji:");
    }

    private void printWeatherInfoOptions() {
        System.out.println(
                "---------------------------------------------------------------------------------------\nCo sprawdzić?");
        System.out.println("    1. Ogólny opis\n    2. Temperatura\n    3. Pogoda na kolejne " + weatherService.getNumberOfDays() + " dni\n    8. Konfiguracja\n    9. Koniec psot");
    }


    private static void handleWrongInput() {
        System.out.println("Niepoprawna wartość. Wybierz jeszcze raz");
    }


}
