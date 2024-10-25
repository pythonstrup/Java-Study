package com.pythonstrup.command.macro;

public class GarageDoorUpCommand implements Command {

  GarageDoor garageDoor;

  public GarageDoorUpCommand(final GarageDoor garageDoor) {
    this.garageDoor = garageDoor;
  }

  @Override
  public void execute() {
    garageDoor.up();
  }
}
