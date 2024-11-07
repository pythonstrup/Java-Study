package com.pythonstrup.state.gamblebonus;

import org.junit.jupiter.api.Test;

class GumballMachineTestDrive {

  @Test
  void test() {
    GumballMachine gumballMachine = new GumballMachine(5);
    System.out.println(gumballMachine);

    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    System.out.println(gumballMachine);

    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    System.out.println(gumballMachine);
  }
}