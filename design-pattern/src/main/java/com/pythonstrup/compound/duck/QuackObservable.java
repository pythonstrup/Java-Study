package com.pythonstrup.compound.duck;

public interface QuackObservable {
  void registerObserver(Observer observer);
  void notifyObservers();
}
