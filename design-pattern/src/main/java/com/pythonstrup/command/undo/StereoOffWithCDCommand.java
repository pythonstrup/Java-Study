package com.pythonstrup.command.undo;

public class StereoOffWithCDCommand implements Command {

  Stereo stereo;

  public StereoOffWithCDCommand(final Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    stereo.off();
  }

  @Override
  public void undo() {
    stereo.on();
    stereo.setCD();
    stereo.setVolume(11);
  }
}
