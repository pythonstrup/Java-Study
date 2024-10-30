package com.pythonstrup.templatemethod.hook;

public abstract class CaffeineBeverageWithHook {

  final void prepareRecipe() {
    boilWater();
    brew();
    pourInCup();
    if (customWantCondiments()) {
      addCondiments();
    }
  }

  public final void boilWater() {
    System.out.println("물 끓이는 중");
  }

  public final void pourInCup() {
    System.out.println("컵에 따르는 중");
  }

  public abstract void brew();
  public abstract void addCondiments();

  boolean customWantCondiments() {
    return true;
  }
}

