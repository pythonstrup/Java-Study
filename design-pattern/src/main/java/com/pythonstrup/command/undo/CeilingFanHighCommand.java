package com.pythonstrup.command.undo;

public class CeilingFanHighCommand implements Command {

  CeilingFan ceilingFan;
  int prevSpeed;

  public CeilingFanHighCommand(final CeilingFan ceilingFan) {
    this.ceilingFan = ceilingFan;
  }

  @Override
  public void execute() {
    prevSpeed = ceilingFan.getSpeed();
    ceilingFan.high();
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
