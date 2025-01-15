package pro.sky.weatherApp.service.Impl;

import org.junit.jupiter.api.Test;
import pro.sky.weatherApp.model.Weather;
import pro.sky.weatherApp.model.WeatherMain;
import pro.sky.weatherApp.model.WeatherWind;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherServiceTestTest {

    @Test
    public void shouldGetTestWeather() {
        // given
        String city = "Moscow";
        WeatherServiceTest weatherServiceTest = new WeatherServiceTest();

        Weather expectedWeather = new Weather();
        WeatherMain expectedMain = new WeatherMain();
        expectedMain.setTemp(BigDecimal.ONE);
        expectedMain.setHumidity(BigDecimal.ONE);
        WeatherWind expectedWind = new WeatherWind();
        expectedWind.setSpeed(BigDecimal.ONE);
        expectedWind.setDeg(1);
        expectedWeather.setMain(expectedMain);
        expectedWeather.setWind(expectedWind);

        // when
        Weather result = weatherServiceTest.getWeather(city);

        // then
        assertEquals(expectedWeather.getMain().getTemp(), result.getMain().getTemp());
        assertEquals(expectedWeather.getMain().getHumidity(), result.getMain().getHumidity());
        assertEquals(expectedWeather.getWind().getSpeed(), result.getWind().getSpeed());
        assertEquals(expectedWeather.getWind().getDeg(), result.getWind().getDeg());
    }

}
