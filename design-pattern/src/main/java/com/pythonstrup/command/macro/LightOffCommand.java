package com.pythonstrup.command.macro;

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
