package com.pythonstrup.observer.weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

  private final List<Observer> observers = new ArrayList<>();

  private double temperature;
  private double humidity;
  private double pressure;

  public WeatherData(final double temperature, final double humidity, final double pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
  }

  @Override
  public void registerObserver(final Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(final Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    observers.forEach(observer -> observer.update(temperature, humidity, pressure));
  }

  public void measurementsChanged(final double temperature, final double humidity, final double pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    notifyObservers();
  }
}
