package com.pythonstrup.command.undo;

public class CeilingFanLowCommand implements Command {

  CeilingFan ceilingFan;
  int prevSpeed;

  public CeilingFanLowCommand(final CeilingFan ceilingFan) {
    this.ceilingFan = ceilingFan;
  }

  @Override
  public void execute() {
    prevSpeed = ceilingFan.getSpeed();
    ceilingFan.low();
  }

  @Override
  public void undo() {
    switch (prevSpeed) {
      case CeilingFan.HIGH -> ceilingFan.high();
      case CeilingFan.MEDIUM -> ceilingFan.medium();
      case CeilingFan.LOW -> ceilingFan.low();
      case CeilingFan.OFF -> ceilingFan.off();
    }
  }
}
