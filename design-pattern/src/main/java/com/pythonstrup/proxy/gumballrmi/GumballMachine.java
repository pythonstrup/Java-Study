package com.pythonstrup.proxy.gumballrmi;

import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

  @Serial
  private static final long serialVersionUID = 2L;

  private State soldOutState;
  private State noQuarterState;
  private State hasQuarterState;
  private State soldState;
  private State winnerState;

  private State state;
  int count = 0;
  String location;

  public GumballMachine(final int numberGumballs, final String location) throws RemoteException {
    soldOutState = new SoldOutState(this);
    noQuarterState = new NoQuarterState(this);
    hasQuarterState = new HasQuarterState(this);
    soldState = new SoldState(this);
    winnerState = new WinnerState(this);

    this.count = numberGumballs;
    this.location = location;
    if (numberGumballs > 0) {
      state = noQuarterState;
    } else {
      state = soldOutState;
    }
  }

  public void insertQuarter() {
    state.insertQuarter();
  }

  public void ejectQuarter() {
    state.ejectQuarter();
  }

  public void turnCrank() {
    state.turnCrank();
    state.dispense();
  }

  @Override
  public String toString() {
    return String.format("알맹이 수: %d, 현재 상태: %s", count, state.toString());
  }

  public State getSoldOutState() {
    return soldOutState;
  }

  public State getNoQuarterState() {
    return noQuarterState;
  }

  public State getHasQuarterState() {
    return hasQuarterState;
  }

  public State getSoldState() {
    return soldState;
  }

  public State getWinnerState() {
    return winnerState;
  }

  public State getState() {
    return state;
  }

  public int getCount() {
    return count;
  }

  public String getLocation() {
    return location;
  }

  public void setSate(final State state) {
    this.state = state;
  }

  public void releaseBall() {
    System.out.println("알맹이를 내보내고 있습니다.");
    if (count > 0) {
      count--;
    }
  }

  public void refillBalls(final int numberGumballs) {
    this.count += numberGumballs;
    System.out.println("리필 중");
    state.refill();
  }
}
