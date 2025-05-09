package com.pythonstrup.command.undo;

public class CeilingFanOffCommand implements Command {

  CeilingFan ceilingFan;
  int prevSpeed;

  public CeilingFanOffCommand(final CeilingFan ceilingFan) {
    this.ceilingFan = ceilingFan;
  }

  @Override
  public void execute() {
    prevSpeed = ceilingFan.getSpeed();
    ceilingFan.off();
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
