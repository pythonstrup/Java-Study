package com.pythonstrup.decorator.coffeesize;

public abstract class CondimentDecorator extends Beverage {

  Beverage beverage;

  public CondimentDecorator(final Beverage beverage) {
    this.beverage = beverage;
  }

  public CoffeeSize getSize() {
    return beverage.getSize();
  }

  public abstract String getDescription();
}
