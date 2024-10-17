package com.pythonstrup.observer.weatherpull;

public class CurrentConditionDisplay implements Observer, DisplayElement {

  private final WeatherData weatherData;

  private double temperature;
  private double humidity;

  public CurrentConditionDisplay(final WeatherData weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void display() {
    System.out.println("현재 상태: 온도 " + temperature + "F, 습도 " + humidity + "%");
  }

  @Override
  public void update() {
    this.temperature = weatherData.getTemperature();
    this.humidity = weatherData.getHumidity();
    display();
  }
}
