package com.pythonstrup.factory.pizza.abstractfactorypattern;

import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.Cheese;
import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.Clam;
import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.Dough;
import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.Pepperoni;
import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.Sauce;
import com.pythonstrup.factory.pizza.abstractfactorypattern.ingredient.Veggie;
import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

  String name;

  Dough dough;
  Sauce sauce;
  Veggie[] veggies;
  Cheese cheese;
  Pepperoni pepperoni;
  Clam clam;

  abstract public void prepare();

  public void bake() {
    System.out.println("175도에서 25분 굽기");
  }

  public void cut() {
    System.out.println("피자를 사선으로 자르기");
  }

  public void box() {
    System.out.println("상자에 피자 담기");
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }
}
