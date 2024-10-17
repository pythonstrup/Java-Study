package com.pythonstrup.decorator.coffee;

public class Mocha extends CondimentDecorator {

  public Mocha(final Beverage beverage) {
    super(beverage);
  }

  @Override
  public double cost() {
    return beverage.cost() + .20;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", 모카";
  }
}
