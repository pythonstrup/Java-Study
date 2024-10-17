package com.pythonstrup.decorator.coffee;

public class Soy extends CondimentDecorator {

  public Soy(final Beverage beverage) {
    super(beverage);
  }

  @Override
  public double cost() {
    return beverage.cost() + .15;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", 두유";
  }
}
