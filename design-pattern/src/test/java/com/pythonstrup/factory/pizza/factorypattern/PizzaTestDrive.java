package com.pythonstrup.factory.pizza.factorypattern;

import org.junit.jupiter.api.Test;

class PizzaTestDrive {

  @Test
  void order() {
    PizzaStore nyStore = new NYPizzaStore();
    PizzaStore chicagoStore = new ChicagoPizzaStore();

    Pizza pizza = nyStore.orderPizza("cheese");
    System.out.println("주문! " + pizza.getName());

    pizza = chicagoStore.orderPizza("cheese");
    System.out.println("주문! " + pizza.getName());
  }
}