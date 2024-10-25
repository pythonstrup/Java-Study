package com.pythonstrup.command.undo;

public class LightOffCommand implements Command {

  Light light;

  public LightOffCommand(final Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.off();
  }

  @Override
  public void undo() {
    light.on();
  }
}
