package com.pythonstrup.proxy.gumball;

public class WinnerState implements State {

  GumballMachine gumballMachine;

  public WinnerState(final GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    System.out.println("알맹이를 내보내고 있습니다.");
  }

  @Override
  public void ejectQuarter() {
    System.out.println("이미 알맹이를 뽑았습니다.");
  }

  @Override
  public void turnCrank() {
    System.out.println("손잡이는 한 번만 돌려주세요.");
  }


  @Override
  public void dispense() {
    gumballMachine.releaseBall();
    if (gumballMachine.getCount() == 0) {
      gumballMachine.setSate(gumballMachine.getSoldOutState());
      return;
    }

    gumballMachine.releaseBall();
    System.out.println("축하드립니다! 알맹이를 하나 더 받으실 수 있습니다.");
    if (gumballMachine.getCount() > 0) {
      gumballMachine.setSate(gumballMachine.getNoQuarterState());
      return;
    }
    System.out.println("더 이상 알맹이가 없습니다.");
    gumballMachine.setSate(gumballMachine.getSoldOutState());
  }

  @Override
  public void refill() {

  }

  @Override
  public String toString() {
    return "당첨";
  }
}
