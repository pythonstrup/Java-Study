package com.pythonstrup.decorator.coffeesize;

public class Milk extends CondimentDecorator {

  public Milk(final Beverage beverage) {
    super(beverage);
  }

  @Override
  public double cost() {
    if (getSize().equals(CoffeeSize.TALL)) {
      return beverage.cost() + .10;
    }
    if (getSize().equals(CoffeeSize.GRANDE)) {
      return beverage.cost() + .20;
    }
    if (getSize().equals(CoffeeSize.VENTI)) {
      return beverage.cost() + .30;
    }
    return beverage.cost();
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", 우유";
  }
}
