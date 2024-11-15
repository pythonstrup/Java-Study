package com.pythonstrup.compound.duck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flock implements Quackable {
  List<Quackable> quackers = new ArrayList<>();
  Observable observable;

  public Flock() {
    this.observable = new Observable(this);
  }

  public void add(Quackable quacker) {
    quackers.add(quacker);
  }

  public void quack() {
    Iterator<Quackable> iterator = quackers.iterator();
    while (iterator.hasNext()) {
      Quackable quacker = iterator.next();
      quacker.quack();
    }
  }

  @Override
  public void registerObserver(final Observer observer) {
    Iterator<Quackable> iterator = quackers.iterator();
    while (iterator.hasNext()) {
      Quackable quacker = iterator.next();
      quacker.registerObserver(observer);
    }
  }

  @Override
  public void notifyObservers() {

  }
}
