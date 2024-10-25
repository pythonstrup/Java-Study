package com.pythonstrup.command.macro;

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
