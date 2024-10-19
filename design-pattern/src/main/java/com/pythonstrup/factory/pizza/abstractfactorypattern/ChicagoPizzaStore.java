package com.pythonstrup.factory.pizza.abstractfactorypattern;

import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.ChicagoPizzaIngredientFactory;
import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.PizzaIngredientFactory;

public class ChicagoPizzaStore extends PizzaStore {

  @Override
  Pizza createPizza(final String type) {
    Pizza pizza = null;
    PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

    if (type.equals("cheese")) {
      pizza = new CheesePizza(ingredientFactory);
      pizza.setName("시카코 스타일 치즈 피자");
    } else if (type.equals("peperoni")) {
      pizza = new PepperoniPizza(ingredientFactory);
      pizza.setName("시카코 스타일 페페로니 피자");
    } else if (type.equals("clam")) {
      pizza = new ClamPizza(ingredientFactory);
      pizza.setName("시카코 스타일 조개 피자");
    } else if (type.equals("veggie")) {
      pizza = new VeggiePizza(ingredientFactory);
      pizza.setName("시카코 스타일 채소 피자");
    }
    return pizza;
  }
}
