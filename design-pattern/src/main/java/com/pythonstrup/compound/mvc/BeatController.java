package com.pythonstrup.compound.mvc;

public class BeatController implements ControllerInterface {

  BeatModelInterface model;
  DjView view;

  public BeatController(final BeatModelInterface model) {
    this.model = model;
    view = new DjView(this, model);
    view.createView();
    view.createControls();
    view.disableStopMenuItem();
    view.enableStartMenuItem();
    model.initialize();
  }

  @Override
  public void start() {
    model.on();
    view.disableStartMenuItem();
    view.enableStopMenuItem();
  }

  @Override
  public void stop() {
    model.off();
    view.disableStopMenuItem();
    view.enableStartMenuItem();
  }

  @Override
  public void increaseBPM() {
    int bpm = model.getBPM();
    model.setBPM(bpm + 1);
  }

  @Override
  public void decreaseBPM() {
    int bpm = model.getBPM();
    model.setBPM(bpm - 1);
  }

  @Override
  public void setBPM(final int bpm) {
    model.setBPM(bpm);
  }
}
