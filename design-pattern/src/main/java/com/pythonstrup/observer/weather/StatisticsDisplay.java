package com.pythonstrup.observer.weather;

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
  public void update(final double temperature, final double humidity, final double pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    display();
  }
}
