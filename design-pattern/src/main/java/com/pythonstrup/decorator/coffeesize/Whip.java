package com.pythonstrup.decorator.coffeesize;

public class Whip extends CondimentDecorator {

  public Whip(final Beverage beverage) {
    super(beverage);
  }

  @Override
  public double cost() {
    return beverage.cost() + .10;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", 휘핑크림";
  }
}
