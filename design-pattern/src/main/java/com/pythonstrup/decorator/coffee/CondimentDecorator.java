package com.pythonstrup.decorator.coffee;

public abstract class CondimentDecorator extends Beverage {

  Beverage beverage;

  public CondimentDecorator(final Beverage beverage) {
    this.beverage = beverage;
  }

  public abstract String getDescription();
}
