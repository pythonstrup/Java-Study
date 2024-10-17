package com.pythonstrup.decorator.coffee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoffeeSystemTest {

  @Test
  @DisplayName("커피를 주문한다.")
  void shouldOrder() {
    Beverage beverage1 = new Espresso();
    System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

    Beverage beverage2 = new DarkRoast();
    beverage2 = new Mocha(beverage2);
    beverage2 = new Mocha(beverage2);
    beverage2 = new Whip(beverage2);
    System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

    Beverage beverage3 = new DarkRoast();
    beverage3 = new Soy(beverage3);
    beverage3 = new Milk(beverage3);
    beverage3 = new Whip(beverage3);
    System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
  }
}