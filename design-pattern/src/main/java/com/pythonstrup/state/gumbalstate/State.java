package com.pythonstrup.state.gumbalstate;

public interface State {

  void insertQuarter();
  void ejectQuarter();
  void turnCrank();
  void dispense();
}
