package pro.sky.weatherApp.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pro.sky.weatherApp.model.Weather;
import pro.sky.weatherApp.service.WeatherService;

/**
 * Реализация сервиса {@link WeatherService} для работы в режиме "production".
 * Использует внешний API для получения данных о погоде.
 */
@Service
@Profile("production")
public class WeatherServiceProduction implements WeatherService {

    Logger logger = LoggerFactory.getLogger(WeatherServiceProduction.class);

    @Value("${weather.url}")
    private String weatherUrl;

    @Value("${weather.api-key}")
    private String weatherApiKey;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Получает данные о погоде для указанного города, используя внешний API.
     *
     * @param city название города, для которого запрашивается погода.
     * @return объект {@link Weather}, содержащий данные о погоде.
     */
    @Override
    public Weather getWeather(String city) {
        logger.debug("Requesting weather for city {}", city);
        Weather weather = restTemplate.exchange(
                weatherUrl,
                HttpMethod.GET,
                new HttpEntity<>(HttpHeaders.EMPTY),
                Weather.class,
                city,
                weatherApiKey
        ).getBody();
        logger.debug("The weather for {} is {}", city, weather);
        return weather;

    }


}
