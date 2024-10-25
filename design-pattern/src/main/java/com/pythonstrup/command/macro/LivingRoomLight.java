package com.pythonstrup.command.macro;

public class LivingRoomLight implements Light {

  public void on() {
    System.out.println("거실 조명 On");
  }

  public void off() {
    System.out.println("거실 조명 Off");
  }
}
