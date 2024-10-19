package com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient;

import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.Cheese;
import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.Clam;
import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.Dough;
import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.Pepperoni;
import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.PizzaIngredientFactory;
import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.Sauce;
import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.Veggie;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

  @Override
  public Dough createDough() {
    return new ThickDough();
  }

  @Override
  public Sauce createSauce() {
    return new PlumTomatoSauce();
  }

  @Override
  public Cheese createCheese() {
    return new MozzarellaCheese();
  }

  @Override
  public Veggie[] createVeggies() {
    return new Veggie[]{new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
  }

  @Override
  public Pepperoni createPepperoni() {
    return new SlicedPepperoni();
  }

  @Override
  public Clam createClam() {
    return new FreshClam();
  }
}
