package pro.sky.weatherApp.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Конфигурационный класс для настройки и создания бина {@link RestTemplate}.
 * Используется для выполнения HTTP-запросов к внешним API.
 */
@Configuration
public class RestTemplateConfiguration {

    /**
     * Создает и возвращает бин {@link RestTemplate}.
     *
     * @return объект {@link RestTemplate}, настроенный с помощью {@link RestTemplateBuilder}.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

}
