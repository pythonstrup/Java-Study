package com.pythonstrup.singleton.classic;

public class VolatileSingleton {
  private volatile static VolatileSingleton uniqueInstance;

  private VolatileSingleton() {}

  public static VolatileSingleton getInstance() {
    if (uniqueInstance == null) {
      synchronized (VolatileSingleton.class) {
        if (uniqueInstance == null) {
          uniqueInstance = new VolatileSingleton();
        }
      }
    }
    return uniqueInstance;
  }
}
