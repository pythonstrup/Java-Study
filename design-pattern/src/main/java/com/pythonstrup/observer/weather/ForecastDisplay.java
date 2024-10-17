package com.pythonstrup.observer.weather;

public class ForecastDisplay implements Observer, DisplayElement {

  private final WeatherData weatherData;

  private double currentPressure = 29.92d;
  private double lastPressure;

  public ForecastDisplay(final WeatherData weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void display() {
    System.out.println("forecast");
  }

  @Override
  public void update(final double temperature, final double humidity, final double pressure) {
    lastPressure = currentPressure;
    currentPressure = pressure;
    display();
  }

  public void removeSubscribing() {
    this.weatherData.removeObserver(this);
  }
}
