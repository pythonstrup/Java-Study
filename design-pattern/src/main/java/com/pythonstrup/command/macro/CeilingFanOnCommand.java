package com.pythonstrup.command.macro;

public class CeilingFanOnCommand implements Command {

  CeilingFan ceilingFan;

  public CeilingFanOnCommand(final CeilingFan ceilingFan) {
    this.ceilingFan = ceilingFan;
  }

  @Override
  public void execute() {
    ceilingFan.on();
  }
}
