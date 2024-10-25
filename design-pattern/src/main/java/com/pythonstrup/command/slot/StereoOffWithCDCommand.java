package com.pythonstrup.command.slot;

public class StereoOffWithCDCommand implements Command {

  Stereo stereo;

  public StereoOffWithCDCommand(final Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    stereo.off();
  }
}
