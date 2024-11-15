package com.pythonstrup.compound.duck;

public class Quackologist implements Observer {

  @Override
  public void update(final QuackObservable duck) {
    System.out.println("꽥꽥학자: " + duck + "가 방금 소리냈다.");
  }
}
