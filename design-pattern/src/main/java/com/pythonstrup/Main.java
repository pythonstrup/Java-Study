package com.pythonstrup;

import com.pythonstrup.observer.weatherpull.CurrentConditionDisplay;
import com.pythonstrup.observer.weatherpull.ForecastDisplay;
import com.pythonstrup.observer.weatherpull.StatisticsDisplay;
import com.pythonstrup.observer.weatherpull.WeatherData;

public class Main {

  public static void main(String[] args) {
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