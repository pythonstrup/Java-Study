package com.pythonstrup.state.gamblerefiil;

import java.util.Random;

public class HasQuarterState implements State {

  Random randomWinner = new Random(System.currentTimeMillis());
  GumballMachine gumballMachine;

  public HasQuarterState(final GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    System.out.println("동전은 한 개만 넣어주세요.");
  }

  @Override
  public void ejectQuarter() {
    System.out.println("동전이 반환됩니다.");
    gumballMachine.setSate(gumballMachine.getNoQuarterState());
  }

  @Override
  public void turnCrank() {
    System.out.println("손잡이를 돌렸습니다.");
    int winner  = randomWinner.nextInt(10);
    if (winner == 0 && gumballMachine.getCount() > 1) {
      gumballMachine.setSate(gumballMachine.getWinnerState());
      return;
    }
    gumballMachine.setSate(gumballMachine.getSoldState());
  }

  @Override
  public void dispense() {
    System.out.println("알맹이를 내보낼 수 없습니다."); // 발생할 수 없는 상황 => 에러를 내야 함.
  }

  @Override
  public void refill() {

  }

  @Override
  public String toString() {
    return "동전 있음";
  }
}
