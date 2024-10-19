package com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient;

import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.Dough;

public interface PizzaIngredientFactory {

  Dough createDough();
  Sauce createSauce();
  Cheese createCheese();
  Veggie[] createVeggies();
  Pepperoni createPepperoni();
  Clam createClam();
}
