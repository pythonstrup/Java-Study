package com.pythonstrup.command.undo;

public class CeilingFanMediumCommand implements Command {

  CeilingFan ceilingFan;
  int prevSpeed;

  public CeilingFanMediumCommand(final CeilingFan ceilingFan) {
    this.ceilingFan = ceilingFan;
  }

  @Override
  public void execute() {
    prevSpeed = ceilingFan.getSpeed();
    ceilingFan.medium();
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
