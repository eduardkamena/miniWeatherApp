package pro.sky.weatherApp.service.Impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pro.sky.weatherApp.model.Weather;
import pro.sky.weatherApp.model.WeatherMain;
import pro.sky.weatherApp.model.WeatherWind;
import pro.sky.weatherApp.service.WeatherService;

import java.math.BigDecimal;

@Service
@Profile("!production")
public class WeatherServiceTest implements WeatherService {

    @Override
    public Weather getWeather(String city) {
        Weather weather = new Weather();
        WeatherMain weatherMain = new WeatherMain();
        weatherMain.setTemp(BigDecimal.ONE);
        weatherMain.setHumidity(BigDecimal.ONE);
        WeatherWind weatherWind = new WeatherWind();
        weatherWind.setSpeed(BigDecimal.ONE);
        weatherWind.setDeg(1);
        weather.setMain(weatherMain);
        weather.setWind(weatherWind);
        return weather;
    }
}
