package com.pythonstrup.singleton.chocolate;

public enum EnumChocolateBoiler {

  UNIQUE_INSTANCE(true, false);

  private boolean empty;
  private boolean boiled;

  EnumChocolateBoiler(final boolean empty, final boolean boiled) {
    this.empty = empty;
    this.boiled = boiled;
  }

  public static EnumChocolateBoiler getInstance() {
    return UNIQUE_INSTANCE;
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
