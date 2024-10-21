package com.pythonstrup.singleton.chocolate;

public class ChocolateBoiler {

  private static ChocolateBoiler uniqueInstance;

  private boolean empty;
  private boolean boiled;

  private ChocolateBoiler() {
    this.empty = true;
    this.boiled = false;
  }

  public static ChocolateBoiler getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new ChocolateBoiler();
    }
    return uniqueInstance;
  }

  public void fill() {
    if (isEmpty()) {
      this.empty = false;
      this.boiled = false;
    }
  }

  public void drain() {
    if (!isEmpty() && isBoiled()) {
      this.empty = true;
    }
  }

  public void boil() {
    if (!isEmpty() && !isBoiled()) {
      this.boiled = true;
    }
  }

  public boolean isEmpty() {
    return empty;
  }

  public boolean isBoiled() {
    return boiled;
  }
}
