package pro.sky.weatherApp.service;

import pro.sky.weatherApp.model.Weather;

/**
 * Интерфейс сервиса для получения данных о погоде.
 */
public interface WeatherService {

    /**
     * Получает данные о погоде для указанного города.
     *
     * @param city название города, для которого запрашивается погода.
     * @return объект {@link Weather}, содержащий данные о погоде.
     */
    Weather getWeather(String city);

}
