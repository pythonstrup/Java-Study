package com.pythonstrup.decorator.coffeesize;

public abstract class Beverage {
  String description = "제목 없음";
  CoffeeSize size = CoffeeSize.TALL;

  public String getDescription() {
    return description;
  }

  public CoffeeSize getSize() {
    return size;
  }

  public void setSize(final CoffeeSize size) {
    this.size = size;
  }

  public abstract double cost();
}
