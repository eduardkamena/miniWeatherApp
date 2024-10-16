package pro.sky.weatherApp.service;

import pro.sky.weatherApp.model.Weather;

public interface WeatherService {

    Weather getWeather(String city);

}
