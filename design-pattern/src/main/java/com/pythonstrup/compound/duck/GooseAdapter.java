package com.pythonstrup.compound.duck;

public class GooseAdapter implements Quackable{

  Goose goose;
  Observable observable;

  public GooseAdapter(final Goose goose) {
    this.goose = goose;
    this.observable = new Observable(this);
  }

  @Override
  public void quack() {
    goose.honk();
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
    return "거위";
  }
}
