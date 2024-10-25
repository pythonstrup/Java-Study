package com.pythonstrup.command.simple;

public class GarageDoorOpenCommand implements Command {

  GarageDoor garageDoor;

  public GarageDoorOpenCommand(final GarageDoor garageDoor) {
    this.garageDoor = garageDoor;
  }

  @Override
  public void execute() {
    garageDoor.up();
  }
}
