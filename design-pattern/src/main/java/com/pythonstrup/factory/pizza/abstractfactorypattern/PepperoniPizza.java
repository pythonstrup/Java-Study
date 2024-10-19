package com.pythonstrup.factory.pizza.abstractfactorypattern;

import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.PizzaIngredientFactory;

public class PepperoniPizza extends Pizza {

  PizzaIngredientFactory pizzaIngredientFactory;

  public PepperoniPizza(final PizzaIngredientFactory pizzaIngredientFactory) {
    this.pizzaIngredientFactory = pizzaIngredientFactory;
  }

  @Override
  public void prepare() {

  }
}
