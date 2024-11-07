package com.pythonstrup.state.gamblebonus;

public interface State {

  void insertQuarter();
  void ejectQuarter();
  void turnCrank();
  void dispense();
}
