package com.pythonstrup.proxy.gumballMonitor;

public class SoldOutState implements State {

  GumballMachine gumballMachine;

  public SoldOutState(final GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    System.out.println("매진되었습니다.");
  }

  @Override
  public void ejectQuarter() {
    System.out.println("동전을 넣지 않았습니다. 동전이 반환되지 않습니다.");
  }

  @Override
  public void turnCrank() {
    System.out.println("매진되었습니다.");
  }

  @Override
  public void dispense() {
    System.out.println("매진되었습니다."); // 발생할 수 없는 상황 => 에러를 내야 함.
  }

  @Override
  public void refill() {
    gumballMachine.setSate(gumballMachine.getNoQuarterState());
  }

  @Override
  public String toString() {
    return "알맹이 매진";
  }
}
