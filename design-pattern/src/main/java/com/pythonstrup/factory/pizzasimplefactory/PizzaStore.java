package com.pythonstrup.factory.pizzasimplefactory;

public class PizzaStore {

  SimplePizzaFactory factory;

  public PizzaStore(final SimplePizzaFactory factory) {
    this.factory = factory;
  }

  Pizza orderPizza(String type) {
    Pizza pizza = factory.createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();
    return pizza;
  }
}
