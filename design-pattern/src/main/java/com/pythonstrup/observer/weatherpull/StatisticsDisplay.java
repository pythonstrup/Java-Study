package com.pythonstrup.observer.weatherpull;

public class StatisticsDisplay implements Observer, DisplayElement {

  private final WeatherData weatherData;

  private double temperature;
  private double humidity;
  private double pressure;

  public StatisticsDisplay(
      final WeatherData weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void display() {
    System.out.println("statistic");
  }

  @Override
  public void update() {
    this.temperature = weatherData.getTemperature();
    this.humidity = weatherData.getHumidity();
    this.pressure = weatherData.getPressure();
    display();
  }
}
