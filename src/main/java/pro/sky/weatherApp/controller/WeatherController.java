package pro.sky.weatherApp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.weatherApp.model.Weather;
import pro.sky.weatherApp.service.WeatherService;

/**
 * Контроллер для обработки запросов, связанных с погодой.
 * Предоставляет REST-эндпоинт для получения данных о погоде по названию города.
 */
@RestController
@Tag(name = "Погода", description = "API для получения информации о погоде")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Operation(
            summary = "Получить погоду по городу",
            description = "Возвращает информацию о погоде для указанного города.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Успешный запрос",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Weather.class),
                                    examples = @ExampleObject(
                                            value = "{\"main\": {\"temp\": 15.0, \"humidity\": 60.0}, \"wind\": {\"speed\": 5.0, \"deg\": 180}}"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Город не найден",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
                                            value = "{\"message\": \"Город не найден\"}"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Ошибка сервера",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
                                            value = "{\"message\": \"Внутренняя ошибка сервера\"}"
                                    )
                            )
                    )
            }
    )
    @GetMapping("weather/{city}")
    public ResponseEntity<Weather> getWeather(
            @Parameter(
                    description = "Название города",
                    example = "Moscow",
                    required = true
            )
            @PathVariable("city") String city) {
        Weather weather = weatherService.getWeather(city);
        return ResponseEntity.ok(weather);
    }

}