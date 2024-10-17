package com.pythonstrup.observer.weather;

public interface Observer {

  void update(final double temperature, final double humidity, final double pressure);
}
