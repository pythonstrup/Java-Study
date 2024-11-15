package com.pythonstrup.compound.duck;

public class MallardDuck implements Quackable {

  Observable observable;

  public MallardDuck() {
    this.observable = new Observable(this);
  }

  @Override
  public void quack() {
    System.out.println("꽥꽥");
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
    return "물오리";
  }
}
