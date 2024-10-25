package com.pythonstrup.command.slot;

public class LightOffCommand implements Command {

  Light light;

  public LightOffCommand(final Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.off();
  }
}
