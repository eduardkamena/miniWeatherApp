package pro.sky.weatherApp.model;

import java.math.BigDecimal;

/**
 * Модель данных, представляющая основные параметры погоды, такие как температура и влажность.
 */
public class WeatherMain {

    private BigDecimal temp;
    private BigDecimal humidity;

    public WeatherMain() {
    }

    public BigDecimal getTemp() {
        return temp;
    }

    public void setTemp(BigDecimal temp) {
        this.temp = temp;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "WeatherMain{" +
                "temp=" + temp +
                ", humidity=" + humidity +
                '}';
    }

}
