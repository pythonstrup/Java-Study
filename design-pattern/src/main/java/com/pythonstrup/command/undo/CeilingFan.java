package com.pythonstrup.command.undo;

public class CeilingFan {

  public static final int HIGH = 3;
  public static final int MEDIUM = 2;
  public static final int LOW = 1;
  public static final int OFF = 0;
  int speed;

  public CeilingFan() {
    speed = OFF;
  }

  public void high() {
    speed = HIGH;
    System.out.println("천장 선풍기 HIGH");
  }

  public void medium() {
    speed = MEDIUM;
    System.out.println("천장 선풍기 MEDIUM");
  }

  public void low() {
    speed = LOW;
    System.out.println("천장 선풍기 LOW");
  }

  public void off() {
    speed = OFF;
    System.out.println("천장 선풍기 OFF");
  }

  public int getSpeed() {
    return speed;
  }
}
