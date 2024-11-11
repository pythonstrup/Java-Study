package com.pythonstrup.proxy.gumballMonitor;

public class NoQuarterState implements State {

  GumballMachine gumballMachine;

  public NoQuarterState(final GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    gumballMachine.setSate(gumballMachine.getHasQuarterState());
    System.out.println("동전을 넣었습니다.");
  }

  @Override
  public void ejectQuarter() {
    System.out.println("동전을 넣어주세요.");
  }

  @Override
  public void turnCrank() {
    System.out.println("동전을 넣어주세요.");
  }

  @Override
  public void dispense() {
    System.out.println("동전을 넣어주세요."); // 발생할 수 없는 상황 => 에러를 내야 함.
  }

  @Override
  public void refill() {

  }

  @Override
  public String toString() {
    return "동전 없음";
  }
}
