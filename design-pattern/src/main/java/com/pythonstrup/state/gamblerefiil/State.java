package com.pythonstrup.state.gamblerefiil;

public interface State {

  void insertQuarter();
  void ejectQuarter();
  void turnCrank();
  void dispense();
  void refill();
}
