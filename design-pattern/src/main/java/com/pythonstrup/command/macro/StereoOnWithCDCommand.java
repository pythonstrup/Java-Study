package com.pythonstrup.command.macro;

public class StereoOnWithCDCommand implements Command {

  Stereo stereo;

  public StereoOnWithCDCommand(final Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    stereo.on();
    stereo.setCD();
    stereo.setVolume(11);
  }
}