package com.pythonstrup.observer.weather;

import com.pythonstrup.observer.weatherpull.CurrentConditionDisplay;
import com.pythonstrup.observer.weatherpull.ForecastDisplay;
import com.pythonstrup.observer.weatherpull.StatisticsDisplay;
import com.pythonstrup.observer.weatherpull.WeatherData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeatherSystemTest {

  @Test
  void test() {
    WeatherData weatherData = new WeatherData(5.0, 20.0, 30.0);
    CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
    StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
    ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

    weatherData.measurementsChanged(80d, 65d, 30.4d);
    forecastDisplay.removeSubscribing();
    weatherData.measurementsChanged(82d, 70d, 29.2d);
    weatherData.measurementsChanged(78d, 90d, 29.2d);
  }
}