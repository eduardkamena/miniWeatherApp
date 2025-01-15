package pro.sky.weatherApp.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import pro.sky.weatherApp.model.Weather;
import pro.sky.weatherApp.model.WeatherMain;
import pro.sky.weatherApp.model.WeatherWind;
import pro.sky.weatherApp.service.WeatherService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherControllerTest {

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController weatherController;

    @Test
    public void testGetWeather() {
        // given
        String city = "Moscow";
        Weather expectedWeather = new Weather();
        expectedWeather.setMain(new WeatherMain());
        expectedWeather.setWind(new WeatherWind());

        // when
        when(weatherService.getWeather(city)).thenReturn(expectedWeather);
        ResponseEntity<Weather> response = weatherController.getWeather(city);

        // then
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedWeather, response.getBody());
    }

}
