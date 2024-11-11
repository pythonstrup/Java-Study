package com.pythonstrup.proxy.gumballMonitor;

public interface State {

  void insertQuarter();
  void ejectQuarter();
  void turnCrank();
  void dispense();
  void refill();
}
