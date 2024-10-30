package com.pythonstrup.adapter.bird;

import java.util.Random;

public class DuckAdapter implements Turkey {

  Duck duck;
  Random random;

  public DuckAdapter(final Duck duck) {
    this.duck = duck;
    this.random = new Random();
  }

  @Override
  public void gobble() {
    duck.quack();
  }

  @Override
  public void fly() {
    if (random.nextInt() % 5 == 0) {
      duck.fly();
    }
  }
}
