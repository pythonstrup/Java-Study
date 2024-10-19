package com.pythonstrup.factory.pizza.abstractfactorypattern;

import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.PizzaIngredientFactory;

public class VeggiePizza extends Pizza {

  PizzaIngredientFactory pizzaIngredientFactory;

  public VeggiePizza(final PizzaIngredientFactory pizzaIngredientFactory) {
    this.pizzaIngredientFactory = pizzaIngredientFactory;
  }

  @Override
  public void prepare() {

  }
}
