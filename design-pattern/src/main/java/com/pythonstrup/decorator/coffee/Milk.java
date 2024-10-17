package com.pythonstrup.decorator.coffee;

public class Milk extends CondimentDecorator {

  public Milk(final Beverage beverage) {
    super(beverage);
  }

  @Override
  public double cost() {
    return beverage.cost() + .10;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", 우유";
  }
}
