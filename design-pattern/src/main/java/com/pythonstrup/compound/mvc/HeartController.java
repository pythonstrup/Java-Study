package com.pythonstrup.compound.mvc;

public class HeartController implements ControllerInterface {
  HeartModelInterface model;
  DjView view;

  public HeartController(final HeartModelInterface model) {
    this.model = model;
    view = new DjView(this, new HeartAdapter(model));
    view.createView();
    view.createControls();
    view.disableStopMenuItem();
    view.enableStartMenuItem();
  }

  @Override
  public void start() {}

  @Override
  public void stop() {}

  @Override
  public void increaseBPM() {}

  @Override
  public void decreaseBPM() {}

  @Override
  public void setBPM(final int bpm) {}
}
