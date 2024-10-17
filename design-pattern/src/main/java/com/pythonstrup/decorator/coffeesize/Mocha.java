package com.pythonstrup.decorator.coffeesize;

public class Mocha extends CondimentDecorator {

  public Mocha(final Beverage beverage) {
    super(beverage);
  }

  @Override
  public double cost() {
    if (getSize().equals(CoffeeSize.TALL)) {
      return beverage.cost() + .20;
    }
    if (getSize().equals(CoffeeSize.GRANDE)) {
      return beverage.cost() + .40;
    }
    if (getSize().equals(CoffeeSize.VENTI)) {
      return beverage.cost() + .60;
    }
    return beverage.cost();
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", 모카";
  }
}
