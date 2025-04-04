package com.pythonstrup.adapter.bird;

public class TurkeyAdapter implements Duck {

  Turkey turkey;

  public TurkeyAdapter(final Turkey turkey) {
    this.turkey = turkey;
  }

  @Override
  public void quack() {
    turkey.gobble();
  }

  @Override
  public void fly() {
    for (int i = 0; i < 5; i++) {
      turkey.fly();
    }
  }
}
