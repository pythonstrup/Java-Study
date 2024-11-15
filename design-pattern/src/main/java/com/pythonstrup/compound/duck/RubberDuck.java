package com.pythonstrup.compound.duck;

public class RubberDuck implements Quackable {

  Observable observable;

  public RubberDuck() {
    this.observable = new Observable(this);
  }

  @Override
  public void quack() {
    System.out.println("삑삑");
    notifyObservers();
  }

  @Override
  public void registerObserver(final Observer observer) {
    observable.registerObserver(observer);
  }

  @Override
  public void notifyObservers() {
    observable.notifyObservers();
  }

  @Override
  public String toString() {
    return "고무오리";
  }
}
