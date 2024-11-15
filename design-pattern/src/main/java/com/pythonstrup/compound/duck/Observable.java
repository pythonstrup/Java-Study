package com.pythonstrup.compound.duck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Observable implements QuackObservable {

  List<Observer> observers = new ArrayList<>();
  QuackObservable duck;

  public Observable(final QuackObservable duck) {
    this.duck = duck;
  }

  @Override
  public void registerObserver(final Observer observer) {
    observers.add(observer);
  }

  @Override
  public void notifyObservers() {
    Iterator<Observer> iterator = observers.iterator();
    while (iterator.hasNext()) {
      Observer observer = iterator.next();
      observer.update(duck);
    }
  }
}
