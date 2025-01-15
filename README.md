# WeatherApp

## Описание

**WeatherApp** — это простое веб-приложение, которое предоставляет информацию о погоде для указанного города. Приложение использует API сервиса [OpenWeatherMap](https://openweathermap.org/) для получения актуальных данных о погоде.

## Основные функции

- Получение данных о погоде (температура, влажность, скорость и направление ветра) по названию города.
- Поддержка двух режимов работы:
    - **Production** — реальные данные от API OpenWeatherMap.
    - **Test** — фиктивные данные для тестирования и разработки.

## Технологии

- **Java 17**
- **Spring Boot 3.3.3**
- **Maven**
- **Spring Web**
- **Spring Boot Test**
- **Springdoc OpenAPI** (для документации API)
- **RestTemplate** (для HTTP-запросов)

## Зависимости

- `spring-boot-starter-web` — для создания веб-приложения.
- `spring-boot-starter-test` — для тестирования.
- `springdoc-openapi-starter-webmvc-ui` — для автоматической генерации документации API (Swagger).

## Установка и запуск

1. Склонируйте репозиторий:
    ```bash
    git clone https://github.com/your-repo/weatherApp.git
    cd weatherApp
    ```
   
2. Убедитесь, что у вас установлены:
   - **Java 17**
   - **Maven**

3. Соберите проект с помощью Maven:
    ```bash
    mvn clean install
    ```
   
4. Запустите приложение:
    ```bash
    mvn spring-boot:run
    ```
   
5. Приложение будет доступно по адресу: http://localhost:8080.

## Использование

### Получение данных о погоде

Чтобы получить данные о погоде, отправьте GET-запрос на эндпоинт:
```
GET /weather/{city}
```
Пример запроса:
```
GET /weather/Moscow
```
Пример запроса через c URL:
```bash
    curl -X GET "http://localhost:8080/weather/Moscow"
```
Пример ответа:
```json
{
  "main": {
    "temp": 15.0,
    "humidity": 60.0
  },
  "wind": {
    "speed": 5.0,
    "deg": 180
  }
}
```

### Документация API

Для просмотра документации API (Swagger UI) перейдите по адресу:
http://localhost:8080/swagger-ui.html.

## Конфигурация

Настройки приложения находятся в файле `application.properties`:
- `weather.url` — URL для запросов к API OpenWeatherMap.
- `weather.api-key` — API-ключ для доступа к OpenWeatherMap.

Пример конфигурации:
```properties
weather.url=https://api.openweathermap.org/data/2.5/weather?q={city}&units=metric&lang=ru&appid={apikey}
weather.api-key=your_api_key_here
```

## Профили

Приложение поддерживает два профиля:
- **Production** — использует реальный API OpenWeatherMap.
- **Test** — возвращает фиктивные данные для тестирования.

Для запуска в определенном профиле используйте флаг `-Dspring.profiles.active`:

```bash
    mvn spring-boot:run -Dspring.profiles.active=test
```

## Дополнительно

Проект находится в стадии разработки и дополнений.