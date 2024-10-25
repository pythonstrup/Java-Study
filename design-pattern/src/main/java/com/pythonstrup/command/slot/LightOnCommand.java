package com.pythonstrup.command.slot;

public class LightOnCommand implements Command {

  Light light;

  public LightOnCommand(final Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.on();
  }
}
