package com.pythonstrup.command.undo;

public class KitchenLight implements Light {

  public void on() {
    System.out.println("부엌 조명 On");
  }

  public void off() {
    System.out.println("부엌 조명 Off");
  }
}
