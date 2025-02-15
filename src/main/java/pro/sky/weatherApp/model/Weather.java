package pro.sky.weatherApp.model;

/**
 * Модель данных, представляющая информацию о погоде.
 * Содержит основные данные о температуре, влажности и ветре.
 */
public class Weather {

    private WeatherMain main;
    private WeatherWind wind;

    public Weather() {
    }

    public WeatherMain getMain() {
        return main;
    }

    public void setMain(WeatherMain main) {
        this.main = main;
    }

    public WeatherWind getWind() {
        return wind;
    }

    public void setWind(WeatherWind wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "main=" + main +
                ", wind=" + wind +
                '}';
    }

}
