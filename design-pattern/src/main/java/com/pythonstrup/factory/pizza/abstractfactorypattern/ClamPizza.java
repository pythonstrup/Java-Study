package com.pythonstrup.factory.pizza.abstractfactorypattern;

import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.PizzaIngredientFactory;

public class ClamPizza extends Pizza {

  PizzaIngredientFactory ingredientFactory;

  public ClamPizza(final PizzaIngredientFactory ingredientFactory) {
    this.ingredientFactory = ingredientFactory;
  }

  @Override
  public void prepare() {
    System.out.println("준비 중: " + name);
    dough = ingredientFactory.createDough();
    sauce = ingredientFactory.createSauce();
    cheese = ingredientFactory.createCheese();
    clam = ingredientFactory.createClam();
  }
}
