package com.pythonstrup.compound.duck;

public class DuckCall implements Quackable {

  Observable observable;

  public DuckCall() {
    this.observable = new Observable(this);
  }

  @Override
  public void quack() {
    System.out.println("꽉꽉");
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
    return "오리호출기";
  }
}
