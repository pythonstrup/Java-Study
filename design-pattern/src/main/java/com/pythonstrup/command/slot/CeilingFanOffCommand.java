package com.pythonstrup.command.slot;

public class CeilingFanOffCommand implements Command{

  CeilingFan ceilingFan;

  public CeilingFanOffCommand(final CeilingFan ceilingFan) {
    this.ceilingFan = ceilingFan;
  }

  @Override
  public void execute() {
    ceilingFan.off();
  }
}
