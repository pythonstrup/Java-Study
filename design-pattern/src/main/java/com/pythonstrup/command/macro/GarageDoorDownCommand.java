package com.pythonstrup.command.macro;

public class GarageDoorDownCommand implements Command {

  GarageDoor garageDoor;

  public GarageDoorDownCommand(final GarageDoor garageDoor) {
    this.garageDoor = garageDoor;
  }

  @Override
  public void execute() {
    garageDoor.down();
  }
}